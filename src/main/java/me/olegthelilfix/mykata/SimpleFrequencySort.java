package me.olegthelilfix.mykata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In this Kata, you will sort elements in an array by decreasing frequency of elements.
 * If two elements have the same frequency, sort them by increasing value.
 * origin https://www.codewars.com/kata/5a8d2bf60025e9163c0000bc/train/java
 */
public class SimpleFrequencySort {
    public static int[] sortByFrequency(int[] array) {
        List<Map.Entry<Integer, Long>> frequencyEntry = new ArrayList<>(calcFrequency(array).entrySet());

        int[] result = new int[array.length];
        int nextIndex = 0;

        while (!frequencyEntry.isEmpty()) {
            Map.Entry<Integer, Long> max = getMax(frequencyEntry);

            if(max != null) {
                for(int i = 0; i < max.getValue(); ++i) {
                    result[nextIndex++] = max.getKey();
                }

                frequencyEntry.remove(max);
            }
        }

        return result;
    }

    private static Map.Entry<Integer, Long> getMax(List<Map.Entry<Integer, Long>> values) {
        if (values.isEmpty()) {
            return null;
        }

        Map.Entry<Integer, Long> max = values.get(0);

        for(int i = 1; i < values.size(); ++i) {
            Map.Entry<Integer, Long> current = values.get(i);
            if (current.getValue() > max.getValue() || (current.getValue().equals(max.getValue()) && current.getKey() < max.getKey())) {
                max = current;
            }
        }

        return max;
    }

    private static Map<Integer, Long> calcFrequency(int[] array) {
        Map<Integer, Long> frequencyMap = new HashMap<>();

        for (int i : array) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0L) + 1);
        }

        return frequencyMap;
    }
}

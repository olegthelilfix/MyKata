package me.olegthelilfix.mykata;

import java.util.Arrays;
import java.util.List;

/**
 * Your goal is to create a function dative() (Dative() in C#) which returns the valid form of a valid Hungarian word
 * w in dative case i. e. append the correct suffix nek or nak to the word w based on vowel harmony rules.
 *
 * Vowel Harmony Rules (simplified)
 *
 * When the last vowel in the word is
 *
 * a front vowel (e, é, i, í, ö, ő, ü, ű) the suffix is -nek
 * a back vowel (a, á, o, ó, u, ú) the suffix is -nak
 *
 * origin https://www.codewars.com/kata/57fd696e26b06857eb0011e7/train/java
 */
public class VowelHarmony {
    private final static List<String> frontVowels = Arrays.asList("e", "é", "i", "í", "ö", "ő", "ü", "ű");
    private final static List<String> backVowels = Arrays.asList("a", "á", "o", "ó", "u", "ú");

    public static String dative(String word) {
        char[] wordArray = word.toCharArray();

        for (int i = wordArray.length - 1; i >= 0; --i) {
            String letterInString = String.valueOf(wordArray[i]);
            if (frontVowels.contains(letterInString)) {
                return word + "nek";
            }
            if (backVowels.contains(letterInString)) {
                return word + "nak";
            }
        }

        return word;
    }
}

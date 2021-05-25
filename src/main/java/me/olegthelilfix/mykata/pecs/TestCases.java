package me.olegthelilfix.mykata.pecs;

import java.util.List;

/**
 * https://habr.com/en/post/559268/
 */
public class TestCases {
    public static List<? extends Class3> tryToExtend(List<? extends Class3> list) {
        Class3 class3 = list.get(0);
        Class1 class1 = list.get(0);
//        Class4 class4 = list.get(0); wrong
//        Class6 class6 = list.get(0); wrong
        return list;
    }

    public static List<? super Class3> tryToSuper(List<? super Class3> list) {
        list.add(new Class3());
        list.add(new Class6());
//        list.add(new Class1()); wrong
//        list.add(new Class2()); wrong
        return list;
    }
}

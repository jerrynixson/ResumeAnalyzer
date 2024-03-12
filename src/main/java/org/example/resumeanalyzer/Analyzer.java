package org.example.resumeanalyzer;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    public static int match(String[] array, String str) {
        if (array == null || array.length == 0 || str == null || str.isEmpty()) {
            return 0;
        }

        int totalStrings = array.length;
        int matchedCount = 0;

        for (String s : array) {
            if (str.contains(s)) {
                matchedCount++;
            }
        }

        return (matchedCount * 100) / totalStrings;
    }

    public static String[] unmatchedSkills(String[] array, String str) {
        if (array == null || array.length == 0 || str == null || str.isEmpty()) {
            return new String[0];
        }

        List<String> unmatchedList = new ArrayList<>();

        for (String s : array) {
            if (!str.contains(s)) {
                unmatchedList.add(s);
            }
        }

        return unmatchedList.toArray(new String[0]);
    }
}

// class MainClass {
//
//    public static void main(String[] args) {
//        String[] array = {"apple", "banana", "orange"};
//        String str = "I like apples and oranges";
//
//        // Testing match method
//        int matchPercentage = Analyzer.match(array, str);
//        System.out.println("Match Percentage: " + matchPercentage + "%");
//
//        // Testing unmatchedStrings method
//        String[] unmatched = Analyzer.unmatchedSkills(array, str);
//        System.out.println("Unmatched Skills:");
//        for (String unmatchedString : unmatched) {
//            System.out.println(unmatchedString);
//        }
//    }
//}




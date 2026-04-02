package com.nahayo.leetcode.string;

public class FindingDifference {

    /***Time O(n) & Space O(1)***/
    public char findTheDifference(String s, String t) {

        // XOR properties:
        // a ^ a = 0  (same values cancel out)
        // a ^ 0 = a  (0 does nothing)
        // XOR is commutative (order doesn't matter)

        char result = 0;

//        // XOR every character in s
//        // Duplicate characters cancel each other out
//        for (char c : s.toCharArray()) {
//            result ^= c;
//        }
//
//        // XOR every character in t
//        // Since t contains one extra character,
//        // all matching characters cancel, leaving only the extra one
//        for (char c : t.toCharArray()) {
//            result ^= c;
//        }


        // XOR all characters in s
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }

        // XOR all characters in t
        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);
        }

        // Return the remaining character
        return result;
    }
}

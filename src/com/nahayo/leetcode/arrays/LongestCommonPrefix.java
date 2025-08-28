package com.nahayo.leetcode.arrays;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Sort the array so the common prefix of all strings
        // will be the common prefix between the first and last.
        Arrays.sort(strs);

        // First and last strings after sorting
        String first = strs[0];
        String last = strs[strs.length - 1];

        // Limit comparison to the length of the shorter string
        int minLength = Math.min(first.length(), last.length());
        int i = 0;

        // Compare characters until they differ or we reach minLength
        while (i < minLength) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        // Common prefix is the substring of first up to i
        return first.substring(0, i);

    }
}

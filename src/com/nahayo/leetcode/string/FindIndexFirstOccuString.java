package com.nahayo.leetcode.string;

public class FindIndexFirstOccuString {

    public int strStrNestedLoopSol(String haystack, String needle) {
        // Edge case: if needle is empty, return 0 by definition
        if (needle.length() == 0) return 0;

        // Loop through each possible starting index in haystack
        // We only need to go up to (haystack.length - needle.length)
        // because needle won't fit beyond that point
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            // Check if needle matches starting at index i
            int j;
            for (j = 0; j < needle.length(); j++) {
                // Compare character by character
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // mismatch found, stop checking further
                }
            }

            // If we reached the end of needle, all characters matched
            if (j == needle.length()) {
                return i; // return the starting index of the first occurrence
            }
        }

        // Needle not found in haystack
        return -1;
    }

    public int strStrSubStringSol(String haystack, String needle) {
        // Edge case: if needle is empty, return 0
        if (needle.length() == 0) return 0;

        // Loop through haystack, only up to a point where needle can fit
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Extract substring of haystack with the same length as needle
            String sub = haystack.substring(i, i + needle.length());

            // Compare the substring with needle
            if (sub.equals(needle)) {
                return i; // Found the first occurrence, return index
            }
        }
        // Needle not found in haystack
        return -1;
    }
}

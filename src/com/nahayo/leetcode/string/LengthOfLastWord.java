package com.nahayo.leetcode.string;

public class LengthOfLastWord {

    /**Time O(n) & Space O(n)**/
    public int lengthOfLastWord(String s) {
        // Remove leading and trailing whitespace
        String stripped = s.trim();

        // Split the string into words using one or more whitespace characters
        String[] strippedArray = stripped.split("\\s+");

        // Get the last word in the array
        String lastWord = strippedArray[strippedArray.length - 1];

        // Return the length of the last word
        return lastWord.length();
    }

    /**Time O(n) & Space O(n)**/
    public int lengthOfLastWordCleanSol(String s) {
        // Remove leading and trailing whitespace
        s = s.trim();

        // Find the index of the last space in the string
        int lastSpaceIndex = s.lastIndexOf(' ');

        // The last word starts at index (lastSpaceIndex + 1).
        // The length of the last word is:
        // total length - starting index of the last word
        return s.length() - lastSpaceIndex - 1;
    }

}

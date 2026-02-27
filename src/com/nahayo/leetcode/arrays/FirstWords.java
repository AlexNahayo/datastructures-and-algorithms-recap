package com.nahayo.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FirstWords {

    /**Time 0(n * m) where N = number of words &
     ** L = average word length &
     ** Space O(1)
     * **/
    public String[] findWords(String[] words) {

        // Strings representing each keyboard row
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        // List to store words that can be typed using one row
        List<String> result = new ArrayList<>();

        // Iterate through every word in the input array
        for (String word : words) {

            // Check if the word belongs entirely to any one row
            if (allInRow(word, row1) ||
                    allInRow(word, row2) ||
                    allInRow(word, row3)) {

                // Add original word (preserve casing)
                result.add(word);
            }
        }

        // Convert List<String> into String[] as required by LeetCode
        return result.toArray(new String[0]);
    }

    // Helper method:
    // Returns true if ALL characters of "word"
    // exist inside the provided keyboard "row"
    private boolean allInRow(String word, String row) {

        // Loop through characters using index
        // (avoids creating a char array via toCharArray())
        for (int i = 0; i < word.length(); i++) {

            // Get character at position i
            char c = word.charAt(i);

            // Convert character to lowercase WITHOUT
            // creating a new lowercase string
            c = Character.toLowerCase(c);

            // Check if the character exists in this keyboard row
            // indexOf returns -1 if character is not found
            if (row.indexOf(c) == -1) {
                // Found a character not in this row → invalid
                return false;
            }
        }

        // All characters were found in the same row
        return true;
    }



    /**Time 0(n * m) where N = number of words &
     ** L = average word length &
     ** Space O(1)
     * Note : Many temporary objects + regex compilation
     * **/
    public String[] findWordsStreams(String[] words) {
        return Stream.of(words)
                .filter( w -> w.toLowerCase()
                .matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]"))
                .toArray(String[]::new);
    }
}
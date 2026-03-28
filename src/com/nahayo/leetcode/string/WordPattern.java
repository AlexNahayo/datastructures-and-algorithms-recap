package com.nahayo.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    /***Time O(n) & Space O(n)***/
    public boolean wordPattern(String pattern, String s) {

        // Split the input string into words
        String[] words = s.split(" ");

        // If pattern length doesn't match number of words,
        // it's impossible for them to follow the same pattern
        if (pattern.length() != words.length) {
            return false;
        }

        // Map to store character -> word mapping
        Map<Character, String> map = new HashMap<>();

        // Set to track words already mapped (to prevent duplicates)
        Set<String> used = new HashSet<>();

        // Iterate through pattern and words simultaneously
        for (int i = 0; i < pattern.length(); i++) {

            // Current pattern character
            char c = pattern.charAt(i);

            // Current word from string
            String word = words[i];

            // If we've already mapped this character before
            if (map.containsKey(c)) {

                // Check if the mapped word matches the current word
                // If not, pattern is broken
                if (!map.get(c).equals(word)) {
                    // character already mapped to a different word
                    return false;
                }
            }
            else {
                // If this word is already mapped to another character,
                // we cannot map it again (must be one-to-one mapping)
                if (used.contains(word)) {
                    // word already mapped to another character
                    return false;
                }

                // Store new mapping
                map.put(c, word);

                // Mark this word as used
                used.add(word);
            }
        }

        // If all checks passed, pattern is valid
        return true;
    }

    /***Time O(n^2) & Space O(n)***/
    public boolean wordPatternSolBruteForce(String pattern, String s) {

        // Split string into words
        String[] words = s.split(" ");

        // If lengths don't match, pattern can't match
        if (pattern.length() != words.length) {
            return false;
        }

        // Map to store pattern char -> word
        Map<Character, String> map = new HashMap<>();

        // Loop through pattern and words
        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            // If we've already seen this character
            if (map.containsKey(c)) {

                // Check if mapping is still correct
                if (!map.get(c).equals(word)) {
                    return false;
                }
            }
            else {
                // Brute force check:
                // Make sure this word isn't already mapped to another character
                for (String value : map.values()) {
                    if (value.equals(word)) {
                        return false;
                    }
                }

                // Store new mapping
                map.put(c, word);
            }
        }
        return true;
    }

}

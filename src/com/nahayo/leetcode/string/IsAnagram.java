package com.nahayo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    /**Time O(s + t) & Space O(s + t)**/
    public boolean bruteForceSol(String s, String t) {

        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency maps for both strings
        Map<Character, Integer> h1 = new HashMap<>();
        Map<Character, Integer> h2 = new HashMap<>();

        // Build frequency map for string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            h1.put(c, h1.getOrDefault(c, 0) + 1);
            // Increment count if character exists, otherwise initialize to 1
        }

        // Build frequency map for string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            h2.put(c, h2.getOrDefault(c, 0) + 1);
        }

        // Compare frequencies from both maps
        for (Map.Entry<Character, Integer> entry : h1.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();

            // Check if character exists in h2 and has the same frequency
            if (!h2.containsKey(c) || h2.get(c) != freq) {
                return false;
            }
        }

        return true;
    }

    /**Time O(s + t) & Space O(1)**/
    public boolean optimalSol(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26]; // 26 letters in the English alphabet

        // Count characters in s
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;  // 1) determines pos in the alphabet & 2) increments count for this char.
        }

        // Subtract counts using t
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;  // decrement count for this char
            if (count[t.charAt(i) - 'a'] < 0) { //check if current value which exists is less than 0.
                return false; // more of this char in t than in s
            }
        }

        return true; // all counts balanced (original count array values should be "0")
    }
}


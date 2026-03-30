package com.nahayo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class RandomNote {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Uses a fixed-size array (26 letters) to store character frequency.
     * This assumes input contains only lowercase English letters.
     */
    public boolean canConstructArraySol(String ransomNote, String magazine) {
        char [] alphabet = new char[26];

        // Count frequency of each character in the magazine
        for (char m : magazine.toCharArray()) {
            // Convert character to index (e.g., 'a' -> 0, 'b' -> 1, ... 'z' -> 25)
            // by subtracting ASCII value of 'a'
            alphabet[m - 'a']++;
        }

        // Check if ransomNote can be constructed using counted characters
        for (char r : ransomNote.toCharArray()) {
            int pos = alphabet[r - 'a'];

            // If character is not available, ransomNote cannot be constructed
            if (pos == 0) {
                return false;
            }

            // Decrease frequency after using the character
            alphabet[r - 'a']--;
        }
        return true;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1) - since max unique characters is limited (26 lowercase letters)
     *
     * Uses HashMap to store character frequency from magazine.
     */
    public boolean canConstructHashMap(String ransomNote, String magazine) {
        Map<Character, Integer> alphabet = new HashMap<>();

        // Count frequency of each character in magazine
        for (char m : magazine.toCharArray()) {
            alphabet.put(m, alphabet.getOrDefault(m, 0) + 1);
        }

        // Check if ransomNote characters exist in magazine
        for (char r : ransomNote.toCharArray()) {
            // If character doesn't exist or frequency is 0, return false
            if (!alphabet.containsKey(r) || alphabet.get(r) == 0)
                return false;

            // Decrease frequency after using the character
            alphabet.put(r, alphabet.get(r) - 1);
        }
        return true;
    }
}

package com.nahayo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharString {

    /***Time O(n) & Space O(1)***/
    public int firstUniqCharSol1(String s) {
        // Create a HashMap to store character frequency
        Map<Character, Integer> charFreqMap = new HashMap<>();

        char[] strArray = s.toCharArray();

        // Count frequency
        for (char c : strArray) {
            // getOrDefault returns 0 if character not yet in map
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }

        // Find first unique character
        int count = 0;
        for (char c : strArray) {
            if (charFreqMap.get(c) == 1) {
                return count;
            }
            count++;
        }

        return -1;
    }

    /***Time O(n) & Space O(1)***/
    public int firstUniqCharSol2(String s) {
        // Create a HashMap to store character frequency
        Map<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            // getOrDefault returns 0 if character not yet in map
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Second pass:
        // Find the first character with frequency = 1
        for (int i = 0; i < s.length(); i++) {
            // If character appears only once, return its index
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If no unique character is found, return -1
        return -1;
    }
}



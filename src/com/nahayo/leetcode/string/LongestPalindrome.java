package com.nahayo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    /***Time O(n) & Space O(n)***/
    public int longestPalindrome(String s) {
        // Step 1: Track frequency of each character
        Map<Character, Integer> charFreq = new HashMap<>();

        // Result stores the length of the longest palindrome
        int result = 0;

        // Build frequency map while counting valid palindrome pairs
        for(char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);

            // Whenever a character count becomes even,
            // we can form a pair and add 2 to the palindrome length
            if (charFreq.get(c) % 2 == 0) {
                result += 2;
            }
        }

        // Check if any character has an odd frequency.
        // If so, we can place one odd character in the center.
        for(int count : charFreq.values()) {
            if(count % 2 == 1) {
                result += 1;
                break;
            }
        }

        return result;
    }
}

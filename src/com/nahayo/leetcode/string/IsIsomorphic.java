package com.nahayo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    /**Time O(n) & Space O(n)**/
    public boolean isIsomorphic(String s, String t) {
        // Bidirectional maps to ensure one-to-one mapping
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check mapping consistency in both directions
            if ((mapST.containsKey(c1) && mapST.get(c1) != c2) ||
                    (mapTS.containsKey(c2) && mapTS.get(c2) != c1)) {
                return false;
            }

            // Record mappings
            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }

        return true;
    }
}

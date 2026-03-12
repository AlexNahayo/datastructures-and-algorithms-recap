package com.nahayo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    /**Time 0(n) & Space O(1)**/
    public int romanToInt(String s) {

        // Map to store Roman numeral symbols and their integer values
        Map<Character, Integer> symbolVal = new HashMap<>();

        symbolVal.put('I', 1);
        symbolVal.put('V', 5);
        symbolVal.put('X', 10);
        symbolVal.put('L', 50);
        symbolVal.put('C', 100);
        symbolVal.put('D', 500);
        symbolVal.put('M', 1000);

        // This will hold the final computed number
        int total = 0;

        // Loop through the string from left to right
        for (int i = 0; i < s.length(); i++) {

            // Get the value of the current Roman character
            int current = symbolVal.get(s.charAt(i));

            // Check if there is a next character to compare with
            if (i < s.length() - 1) {

                // Get the value of the next Roman character
                int next = symbolVal.get(s.charAt(i + 1));

                /*
                 If the current value is smaller than the next value,
                 this means we are in a subtractive case like:
                 IV = 4
                 IX = 9
                 XL = 40
                 CM = 900

                 Example: I before V → subtract I
                */
                if (current < next) {
                    total -= current;
                }
                else {
                    // Otherwise we add the value normally
                    total += current;
                }

            } else {
                // If it is the last character, just add it
                total += current;
            }
        }

        // Return the computed total
        return total;
    }
}

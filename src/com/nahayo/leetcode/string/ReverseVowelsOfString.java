package com.nahayo.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {

    /***Time O(n) & Space O(1)***/
    public String reverseVowels(String s) {
        // Step 1: Define a set of vowels for quick lookup
        // Include both lowercase and uppercase vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a','e','i','o','u',
                'A','E','I','O','U'
        ));

        // Step 2: Convert string to a char array
        // Strings are immutable in Java, but we can modify arrays in-place
        char[] chars = s.toCharArray();

        // Step 3: Initialize two pointers
        int left = 0;               // Start from the beginning
        int right = chars.length - 1; // Start from the end

        // Step 4: Move pointers toward each other
        while (left < right) {

            // Skip non-vowels from the left
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Skip non-vowels from the right
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Step 5: Swap vowels at left and right pointers
            // (At this point have reached vowels to swap)
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Step 6: Move both pointers inward
            left++;
            right--;
        }

        // Step 7: Convert char array back to string and return
        return new String(chars);
    }

    /***Time O(n) & Space O(n)***/
    public String reverseVowelsBruteForce(String s) {

        // Step 1: Define a set of vowels for quick lookup
        // Only lowercase vowels are included here; can add uppercase if needed
        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a','e','i','o','u',
                'A','E','I','O','U'
        ));

        // Step 2: Collect all vowels from the string in reverse order
        // This will allow us to "replace" vowels in original string with reversed ones
        StringBuilder reversedArray = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                reversedArray.append(c); // Append vowels starting from the end
            }
        }

        // Step 3: Convert the original string to a StringBuilder
        // Strings are immutable in Java, so we need a mutable structure to modify characters
        StringBuilder result = new StringBuilder(s);

        // Step 4: Replace vowels in the original string with vowels from reversedArray
        int count = 0; // Index for reversedArray
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (vowels.contains(c)) {
                // Replace current vowel with the next vowel from reversedArray
                result.setCharAt(i, reversedArray.charAt(count));
                count++; // Move to the next vowel in reversedArray
            }
        }

        // Step 5: Return the final string with vowels reversed
        return result.toString();
    }
}

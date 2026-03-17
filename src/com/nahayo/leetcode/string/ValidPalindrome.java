package com.nahayo.leetcode.string;

public class ValidPalindrome {

    /***Time O(n) & Space O(n)***/
    public boolean isPalindrome(String s) {
        // Step 1: Remove all non-alphanumeric characters and convert to lowercase
        String cleaned = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();

        // Step 2: Reverse the cleaned string
        String reversed = new StringBuilder(cleaned)
                .reverse()
                .toString();

        // Step 3: Compare original cleaned string with reversed version
        return cleaned.equals(reversed);
    }

    /***Time O(n) & Space O(1)***/
    public boolean isPalindromeTwoPointersSol(String s) {
        // Initialize two pointers at the start and end of the string
        int left = 0;
        int right = s.length() - 1;

        // Loop until the two pointers meet
        while (left < right) {

            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric characters on the left side
            if (!Character.isLetterOrDigit(l)) {
                left++;
            }
            // Skip non-alphanumeric characters on the right side
            else if (!Character.isLetterOrDigit(r)) {
                right--;
            }
            else {
                // Compare characters (case-insensitive)
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false; // Not a palindrome
                }

                // Move both pointers inward
                left++;
                right--;
            }
        }

        return true;
    }

    /***Time O(n) & Space O(1)***/
    public boolean isPalindromeAsciiTwoPointersSolSol(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric on the left using ASCII ranges
            if (!isAlphaNumeric(l)) {
                left++;
            }
            // Skip non-alphanumeric on the right using ASCII ranges
            else if (!isAlphaNumeric(r)) {
                right--;
            }
            else {
                // Convert uppercase letters to lowercase manually (ASCII trick)
                if (toLower(l) != toLower(r)) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }

    // Check if character is a letter or digit using ASCII values
    private boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9');
    }

    // Convert uppercase to lowercase using ASCII
    private char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32); // ASCII difference between uppercase and lowercase
        }
        return c;
    }

}

package com.nahayo.leetcode.string;

public class ReverseString {

    /***Time O(n) & Space O(1)***/
    public void reverseString(char[] s) {
        // Pointer starting from the beginning of the array
        int left = 0;

        // Pointer starting from the end of the array
        int right = s.length - 1;

        // Continue swapping until the two pointers meet
        while (right > left ) {
            // Store the left character temporarily
            char temp = s[left];

            // Swap left and right characters
            s[left] = s[right];
            s[right] = temp;

            // Move left pointer forward
            left++;

            // Move right pointer backward
            right--;
        }
    }

    /***Time O(n) & Space O(n)***/
    public void reverseStringBruteForce(char[] s) {
        // Create a new array to store reversed characters
        char[] reverse = new char[s.length];
        int count = 0;

        // Fill reverse array
        for (int i = s.length - 1; i >=0 ; i--) {
            reverse[count] = s[i];
            count++;
        }

        // Copy back to original array
        for (int i = 0; i < s.length; i++) {
            s[i] = reverse[i];
        }
    }
}

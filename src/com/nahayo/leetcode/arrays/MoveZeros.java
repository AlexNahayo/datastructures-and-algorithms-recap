package com.nahayo.leetcode.arrays;

public class MoveZeros {
    /**
     * Moves all zeros in the array to the end while keeping the order of non-zero numbers the same.
     * Time: O(n)
     * Space: O(1)
     */
    public static void moveZeros(int[] nums) {
        int insertPosition = 0;

        // Step 1: Go through each number in the array
        // If the number isn't zero, place it at the next available position (insertPosition)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }

        // Step 2: After moving all non-zero numbers,
        // fill the rest of the array with zeros
        while (insertPosition < nums.length) {
            nums[insertPosition++] = 0;
        }
    }
}

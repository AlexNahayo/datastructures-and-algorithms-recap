package com.nahayo.leetcode.arrays;

public class MissingNumber {

    /**Space O(1) & Time (n)*/
    public static int missingNumberXOR(int[] nums) {
        // Initialize resultXOR to 0. We'll XOR all numbers in nums and the range [0..n].
        int resultXOR = 0;

        // XOR all elements in the nums array.
        for (int i = 0; i < nums.length; i++) {
            resultXOR ^= nums[i]; // resultXOR = resultXOR^nums[i];
        }

        // XOR all numbers from 0 to n (inclusive), where n = nums.length.
        for (int i = 0; i <= nums.length; i++) {
            resultXOR ^= i; // resultXOR = resultXOR^i;
        }

        // The remaining value in resultXOR is the missing number.
        return resultXOR;
    }

    /**Space O(1) & Time (n)*/
    public static int missingNumberMath(int[] nums) {
        // The expected sum of numbers from 0 to n (inclusive) using the Arithmetic series formula: n * (n + 1) / 2
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        // Calculate the actual sum of all elements in the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The difference between the expected and actual sums gives the missing number
        return expectedSum - actualSum;
    }

}

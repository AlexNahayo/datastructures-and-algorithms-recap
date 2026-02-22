package com.nahayo.leetcode.arrays;


/** Time O(n) & Space O(1) **/
public class MaxConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 1) {
                // Current element is 1 → increase current streak
                count++;
                // Update maxCount if current streak is larger
                maxCount = Math.max(maxCount, count);
            } else {
                // Current element is 0 → reset current streak
                count = 0;
            }
        }

        return maxCount;
    }
}

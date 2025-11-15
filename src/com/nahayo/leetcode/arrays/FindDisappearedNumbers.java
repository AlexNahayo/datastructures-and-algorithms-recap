package com.nahayo.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    /**Space O(1) & Time 0(n)**/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(); // List to store the missing numbers

        // First pass: mark numbers as seen by negating the value at the corresponding index
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Convert value to 0-based index
            if (nums[index] > 0) {             // Only negate if the value is positive (not yet visited)
                nums[index] = -nums[index];    // Mark as visited
            }
        }

        // Second pass: collect indices that were never marked (still positive)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {                 // Positive value means the number (i + 1) is missing
                result.add(i + 1);             // Add missing number to result list
            }
        }

        return result; // Return all missing numbers
    }
}

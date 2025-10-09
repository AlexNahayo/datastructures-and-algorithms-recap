package com.nahayo.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {


    /**Space O(n) & Time O(n)**/
    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>(); // List to store the resulting consecutive ranges.

        if (nums.length == 0) return result; // Return an empty list if the input array is empty.

        int start = nums[0]; // Track the start of the current range.

        for (int i = 1; i <= nums.length; i++) {
            // If we've reached the end of the array OR the current number is not consecutive with the previous one
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {

                // Add the current range to the result
                if (start == nums[i - 1]) {
                    // Single number range
                    result.add(String.valueOf(start));
                } else {
                    // Range with more than one number
                    result.add(start + "->" + nums[i - 1]);
                }

                // Update start for the next range (only if not at the end)
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return result;
    }
}

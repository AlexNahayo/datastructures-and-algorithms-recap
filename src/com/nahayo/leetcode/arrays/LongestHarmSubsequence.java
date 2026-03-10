package com.nahayo.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmSubsequence {

    /**Time 0(n) & Space O(1)
     **/
    public int longestHarmoniousSubsequenceLinearSol(int[] nums) {

        // Create a map to store the frequency (count) of each number in the array
        Map<Integer, Integer> freq = new HashMap<>();

        // Iterate through every number in the input array
        for (int n : nums) {

            // Update the count of n in the map
            // getOrDefault(n, 0) returns the current count if present, otherwise 0
            // then we add 1 because we found another occurrence of n
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // This variable will store the maximum harmonious subsequence length found
        int max = 0;

        // Iterate through every unique number stored in the frequency map
        for (int key : freq.keySet()) {

            // Check if the map contains a number exactly 1 greater than the current key
            // because a harmonious subsequence requires max - min = 1
            if (freq.containsKey(key + 1)) {

                // Calculate the combined frequency of key and key+1
                // this represents the length of a harmonious subsequence
                int length = freq.get(key) + freq.get(key + 1);

                // Update max if this subsequence is longer than any seen before
                max = Math.max(max, length);
            }
        }

        // Return the longest harmonious subsequence length found
        return max;
    }

    /**Time O(n log n) & Space O(1)
     **/
    public int longestHarmoniousSubsequenceSlidingWindowSol(int[] nums) {

        // Step 1: sort the array so similar values are grouped
        Arrays.sort(nums);

        int left = 0;
        int max = 0;

        // Step 2: expand the right pointer
        for (int right = 0; right < nums.length; right++) {

            // Step 3: shrink window if difference exceeds 1
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            // Step 4: valid harmonious subsequence
            if (nums[right] - nums[left] == 1) {
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }


}

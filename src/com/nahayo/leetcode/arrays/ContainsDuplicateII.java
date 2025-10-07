package com.nahayo.leetcode.arrays;

import java.util.HashSet;

public class ContainsDuplicateII {


    /**Time 0(n) & Space 0(k) **/
    public static boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        // Declare a HashSet to store unique values within the current sliding window.
        HashSet<Integer> window = new HashSet<>();

        // Iterate through the nums array.
        for (int i = 0; i < nums.length; i++) {
            // If the current number already exists in the window,
            // it means we found a duplicate within distance k.
            if (window.contains(nums[i])) {
                return true;
            }

            // Add the current number to the window.
            window.add(nums[i]);

            // If the window size exceeds k, remove the oldest element
            // (the one that is now more than k indices behind).
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        // No duplicates found within distance k.
        return false;
    }
}

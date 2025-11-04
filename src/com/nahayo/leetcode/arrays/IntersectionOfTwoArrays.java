package com.nahayo.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    /**Space O(n) & Time 0(n)**/
    public int[] intersection(int[] nums1, int[] nums2) {
        // Step 1: Store all unique numbers from nums1 in a HashSet
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Step 2: Create another HashSet to store the intersection
        Set<Integer> intersection = new HashSet<>();

        // Step 3: Check each number in nums2
        // If it's in set1, it's part of the intersection
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        // Step 4: Convert the intersection set directly to an int array
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }

        // Step 5: Return the final array
        return result;
    }
}
package com.nahayo.leetcode.arrays;

import java.util.*;

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

    /**Space O(n) & Time 0(n)**/
    public int[] intersectionII(int[] nums1, int[] nums2) {
        // Map to count how many times each number appears in nums1
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        // Count the frequency of each number in nums1
        for (int num1 : nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }

        // Check each number in nums2
        for (int num2 : nums2) {
            // If num2 exists in nums1 (map) and count > 0, it's part of the intersection
            if (map.containsKey(num2) && map.get(num2) > 0) {
                list.add(num2);                        // Add it to result
                map.put(num2, map.get(num2) - 1);      // Decrease its count
            }
        }

        // Convert list to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result; // Return the intersection array
    }
}
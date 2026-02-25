package com.nahayo.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    // Let's do the brute force way first
    // Time 0(m^2) and Space O(n^2).
    public int[] nextGreaterElementBF(int[] nums1, int[] nums2) {
        // Create a map for nums1
        // Key   = value in nums1
        // Value = index where that value appears in nums1
        //
        // Example:
        // nums1 = [1,2,3]
        // Map becomes:
        // 1 -> 0
        // 2 -> 1
        // 3 -> 2
        //
        // This helps us quickly place answers into the result array later.
        Map<Integer, Integer> nums1ValMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1ValMap.put(nums1[i], i);
        }

        // Result array
        // We initialize everything to -1 because
        // if a next greater element does not exist,
        // the answer should stay -1.
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        /*
            Why the map helps:

            1) Quickly check if a value from nums2 exists in nums1.
               If it doesn't, we can skip work.

            2) If we DO find the next greater value,
               we know exactly where to place it in the result array.
        */
        // Loop through nums2
        for (int j = 0; j < nums2.length; j++) {

            // If this value from nums2 is not in nums1,
            // we don't care about it.
            if (!nums1ValMap.containsKey(nums2[j])) {
                continue;
            }

            // If it exists in nums1, we now try to find
            // the next greater element to the RIGHT of it in nums2.
            for (int k = j + 1; k < nums2.length; k++) {

                // j = original number
                // k = numbers that come after it
                int originalValue = nums2[j];
                int nextGreatestValue = nums2[k];

                // Check if we found a greater number
                if (nextGreatestValue > originalValue) {

                    // 1) Find where this number lives in nums1
                    int index = nums1ValMap.get(originalValue);

                    // 2) Put the next greater value in the result
                    result[index] = nextGreatestValue;

                    // Stop because we only want the FIRST greater value
                    break;
                }

                // If we never find a greater value,
                // the result stays -1 (which is correct).
            }
        }
        return result;
    }

    // More efficient solution using Monotonic Stack.
    // Time 0(n + m) and Space O(n).
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Map value -> index in nums1
        Map<Integer, Integer> nums1ValMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1ValMap.put(nums1[i], i);
        }

        // Result array (default -1)
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        // Stack stores values from nums1 that we still need NGE for
        Stack<Integer> stack = new Stack<>();

        // Iterate through nums2
        for (int j = 0; j < nums2.length; j++) {

            int current = nums2[j];

            // While stack is not empty
            // and current is greater than stack top
            // we found the Next Greater Element
            while (!stack.isEmpty() && current > stack.peek()) {

                int value = stack.pop();                 // value from nums1
                int index = nums1ValMap.get(value);      // and find its index in nums1 from our Map
                result[index] = current;                 // now  take this index and sets its value as current
            }

            // Only push in to stack if current exists in nums1
            if (nums1ValMap.containsKey(current)) {
                stack.push(current);
            }
        }

        return result;
    }
}

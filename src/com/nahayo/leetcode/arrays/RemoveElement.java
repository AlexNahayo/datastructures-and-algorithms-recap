package com.nahayo.leetcode.arrays;

public class RemoveElement {


    /**Space (1) & Time (n)**/
    public static int removeElement(int[] nums, int val) {
        int i = 0; // write pointer
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; // i is the count of valid elements
    }
}

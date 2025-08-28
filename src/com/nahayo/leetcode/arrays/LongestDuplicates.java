package com.nahayo.leetcode.arrays;

public class LongestDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer: marks the position of the last unique element

        for (int j = 1; j < nums.length; j++) {
            // check if nums[j] is a new unique value
            if (nums[j] != nums[i]) {
                i++;
                // copy the unique value found at nums[j] into the next position (i)
                nums[i] = nums[j];
            }
        }

        // return length of unique portion (i is index, so +1 gives count)
        return i + 1;
    }
}

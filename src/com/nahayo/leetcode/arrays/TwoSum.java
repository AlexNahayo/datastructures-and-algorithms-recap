package com.nahayo.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**Naive Solution - Brute Force**/
    /**Space (1) & Time (n^2)**/
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int[] index = new int[2];
        outer: for (int i = 0; i < nums.length; i++) {
            for(int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] =  i;
                    index[1] =  j;
                    break outer;
                }
            }
        }
        return index;
    }

    /**Naive Solution - Brute Force**/
    /**Space (1) & Time (n)**/
    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // store compliment key -> complement value and value index of complement.
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                index[0] = map.get(complement);
                index[1] = i;
                break ;
            }
            map.put(nums[i], i);
        }
        return index;
    }
}

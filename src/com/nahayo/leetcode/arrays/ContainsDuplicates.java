package com.nahayo.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    /**Space O(n) & Time (n)**/
    public static boolean containsDuplicate(int[] nums) {
        // Use a HashSet to track numbers we've already seen.
        // A HashSet cannot contain duplicate elements.
        Set<Integer> seen = new HashSet<>();

        // Loop through each number
        for (int num : nums) {
            // If add() returns false, the number was already in the set → duplicate
            if (!seen.add(num)) {
                return true;
            }
        }
        // If we finish the loop, no duplicates were found
        return false;
    }

    //will add other solutions later
}

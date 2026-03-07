package com.nahayo.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    /**Time 0(n) & Space O(m),
     * where n = candyType.length &
     * m = number of unique candy types**/
    public int distributeCandies(int[] candyType) {

        // Step 1: Calculate the maximum number of candies the sister can eat.
        // She can only eat half of the total candies.
        int maxCandiesSheCanEat = candyType.length / 2;

        // Step 2: Create a HashSet to store unique candy types.
        // A HashSet automatically ignores duplicates.
        Set<Integer> uniqueCandyTypes = new HashSet<>();

        // Step 3: Iterate through the candyType array
        // and add each candy type to the set.
        for (int candy : candyType) {
            uniqueCandyTypes.add(candy);
        }

        // Step 4: Determine how many unique candy types exist.
        int uniqueTypesCount = uniqueCandyTypes.size();

        // Step 5: The sister wants to maximize the number of different types,
        // but two limits apply:
        // 1. She cannot eat more than n/2 candies.
        // 2. She cannot eat more types than actually exist.
        // Therefore we return the smaller of the two.
        return Math.min(maxCandiesSheCanEat, uniqueTypesCount);
    }
}

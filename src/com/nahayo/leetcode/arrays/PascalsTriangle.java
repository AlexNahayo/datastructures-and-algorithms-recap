package com.nahayo.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /**Brute Force Solution**/

    /**Space Complexity 0 (n^2)** or 0(n) with Auxiliary space & Time Complexity 0 (n^2)**/
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // Build each row one by one
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // First and last elements are always 1
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Middle elements are sum of the two above
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(val);
                }
            }

            result.add(row);
        }

        return result;
    }
}

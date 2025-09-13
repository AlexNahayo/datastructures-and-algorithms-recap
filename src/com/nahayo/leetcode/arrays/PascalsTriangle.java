package com.nahayo.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /**Brute Force Solution**/

    /**Space Complexity 0 (n^2)** or 0(n) with Auxiliary space & Time Complexity 0 (n^2)**/
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return null; // Usually, it's better to return an empty list instead of null
        }

        // Declare a 2D list to represent Pascal's triangle
        List<List<Integer>> result = new ArrayList<>();

        // Build each row in the 2D list
        for (int i = 0; i < numRows; i++) {
            // Declare the current row
            List<Integer> row = new ArrayList<>();

            // Loop through the positions in the current row
            for (int j = 0; j <= i; j++) {
                // In Pascal's triangle, the first and last elements of each row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Other elements are the sum of the two elements directly above
                    int value = result.get(i - 1).get(j - 1)   // left element from the previous row
                            + result.get(i - 1).get(j);    // right element from the previous row
                    row.add(value);
                }
            }

            // Add the completed row to the triangle
            result.add(row);
        }

        return result;
    }
}

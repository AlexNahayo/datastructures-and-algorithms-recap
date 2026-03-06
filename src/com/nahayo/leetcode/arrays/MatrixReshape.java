package com.nahayo.leetcode.arrays;

public class MatrixReshape {
    public int[][] matrixReshapeModSolution(int[][] mat, int r, int c) {

        // Get dimensions of original matrix
        int m = mat.length;       // number of rows
        int n = mat[0].length;    // number of columns

        // If total number of elements doesn't match, reshape is impossible
        if (m * n != r * c) {
            return mat;
        }

        // If dimensions are the same, no need to reshape
        if (m == r && n == c) {
            return mat;
        }

        // Create new reshaped matrix
        int[][] reshaped = new int[r][c];

        // Traverse elements using a single linear index
        for (int i = 0; i < m * n; i++) {

            // Map linear index to original matrix position
            int oldRow = i / n;
            int oldCol = i % n;

            // Map same linear index to new matrix position
            int newRow = i / c;
            int newCol = i % c;

            reshaped[newRow][newCol] = mat[oldRow][oldCol];
        }

        return reshaped;
    }

    public int[][] matrixReshapeLoopSolution(int[][] nums, int r, int c) {

        // Original matrix dimensions
        int rows = nums.length;
        int columns = nums[0].length;

        // If total number of elements is different, reshaping is not possible
        if ((rows * columns) != (r * c))
            return nums;

        // Create the new reshaped matrix
        int[][] reshaped = new int[r][c];

        // Pointers to track the position in the reshaped matrix
        int row_num = 0;
        int column_num = 0;

        // Traverse the original matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                // Copy current element into the reshaped matrix
                reshaped[row_num][column_num] = nums[i][j];

                // Move to the next column in the reshaped matrix
                column_num++;

                // If we reach the end of a row, move to the next row
                if (column_num == c) {
                    column_num = 0;
                    row_num++;
                }
            }
        }

        return reshaped;
    }
}

package com.nahayo.leetcode.arrays;


/** Time 0(n ^2) & Space O(n ^2) - more formally 0(R * C) **/
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        //We are guaranteed exactly one island.
        //So we just scan the grid until we find the first land cell (1)
        //and start DFS from there.
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1) {
                    return dfs(r, c, grid);
                }

            }
        }

        //Fallback return (problem guarantees an island exists)
        return 0;
    }

    public int dfs(int r, int c, int[][] grid) {

        //BASE CASE 1
        //If we go outside the grid, the previous land cell
        //had an exposed edge contributing to the perimeter.
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 1;
        }

        //BASE CASE 2
        //If we hit water, that edge also contributes
        //to the island perimeter.
        if (grid[r][c] == 0) {
            return 1;
        }

        //BASE CASE 3
        //If we already visited this land cell,
        //we stop to avoid double counting.
        if (grid[r][c] == -1) {
            return 0;
        }

        //Mark this cell as visited.
        grid[r][c] = -1;

        int perimeter = 0;

        //Explore all 4 directions from the current cell.

        //right
        perimeter += dfs(r, c + 1, grid);

        //down
        perimeter += dfs(r + 1, c, grid);

        //left
        perimeter += dfs(r, c - 1, grid);

        //up
        perimeter += dfs(r - 1, c, grid);

        return perimeter;
    }
}
package com.nahayo.queue;

import java.util.*;

public class CastleOnTheGrid {

    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        int[] dx = {1, -1, 0, 0};  // Down, Up
        int[] dy = {0, 0, 1, -1};  // Right, Left

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == goalX && current.y == goalY) {
                return current.dist;
            }

            // Explore in 4 directions
            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x;
                int ny = current.y;

                // Keep moving in the same direction until obstacle or edge
                while (true) {
                    nx += dx[dir];
                    ny += dy[dir];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                    if (grid[nx].charAt(ny) == 'X') break;
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, current.dist + 1));
                }
            }
        }
        return -1;  // Should never happen if input is valid
    }


}

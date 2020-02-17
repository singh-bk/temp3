package com.uber.www;

import java.util.LinkedList;
import java.util.Queue;

public class Island {

    public static void main(String[] args) {
        final char[][] input = {{'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}};
        final Island obj = new Island();
        System.out.println(obj.numIslands(input));
    }

    public int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }
        final int row = grid.length;
        int col = 0;
        if (grid[0].length > 0) {
            col = grid[0].length;
        }

        final boolean[][] visited = new boolean[row][col];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    final Queue<Integer> queue = new LinkedList<Integer>();
                    queue.add(i * col + j);
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        final Integer str = queue.poll();

                        final int rr = str / col;
                        final int cc = str % col;
                        if (rr - 1 >= 0 && grid[rr - 1][cc] == '1' && !visited[rr - 1][cc]) {
                            queue.add((rr - 1) * col + cc);
                            visited[rr - 1][cc] = true;

                        }
                        if (rr + 1 < row && grid[rr + 1][cc] == '1' && !visited[rr + 1][cc]) {
                            queue.add((rr + 1) * col + cc);
                            visited[rr + 1][cc] = true;

                        }
                        if (cc - 1 >= 0 && grid[rr][cc - 1] == '1' && !visited[rr][cc - 1]) {
                            queue.add(rr * col + (cc - 1));
                            visited[rr][cc - 1] = true;

                        }
                        if (cc + 1 < col && grid[rr][cc + 1] == '1' && !visited[rr][cc + 1]) {
                            queue.add(rr * col + (cc + 1));
                            visited[rr][cc + 1] = true;

                        }
                    }
                }
            }
        }

        return count;
    }
}

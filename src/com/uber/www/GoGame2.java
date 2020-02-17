package com.uber.www;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GoGame2 {


    public static void main(String[] args) {
        final int[][] input = {{0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 1, 2, 1, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0}};

        final int[][] input2 = {{0, 0, 0, 0, 0, 0}, {0, 0, 2, 0, 0, 0}, {0, 2, 1, 2, 0, 0}, {0, 2, 1, 1, 2, 0},
                        {0, 0, 2, 2, 0, 0}, {0, 0, 0, 0, 0, 0}};
        final int[][] input3 = {{0, 0, 0, 0, 0, 0}, {0, 0, 2, 0, 0, 0}, {0, 2, 1, 2, 0, 0}, {0, 2, 1, 1, 0, 0},
                        {0, 0, 2, 2, 0, 0}, {0, 0, 0, 0, 0, 0}};


        final GoGame2 obj = new GoGame2();
        System.out.println(obj.getCapturedStones(input));
        System.out.println(obj.getCapturedStones(input2));
        System.out.println(obj.getCapturedStones(input3));
        System.out.println(obj.isCaptured(input2, 2, 2));
        System.out.println(input2[1][2]);
        System.out.println(obj.isCapturedWithoutVisited(input2, 2, 2));
        System.out.println(obj.isCaptured(input3, 2, 2));
        System.out.println(obj.isCapturedWithoutVisited(input3, 2, 2));
    }

    public Set<Integer> getCapturedStones(int[][] input) {
        final Set<Integer> op = new HashSet<Integer>();
        final int row = input.length;
        final int col = input[0].length;

        final boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((input[i][j] == 1 || input[i][j] == 2) && !visited[i][j]) {
                    final int current = input[i][j];
                    final int opponent = (current == 1) ? 2 : 1;
                    final Queue<Integer> queue = new LinkedList<Integer>();
                    queue.add(i * col + j);
                    visited[i][j] = true;
                    boolean captured = true;
                    final List<Integer> capturedList = new ArrayList<Integer>();
                    capturedList.add(i * col + j);
                    while (!queue.isEmpty()) {
                        final int temp = queue.remove();
                        final int rr = temp / col;
                        final int cc = temp % col;

                        if ((rr - 1 < 0 || input[rr - 1][cc] == 0) || (rr + 1 >= row || input[rr + 1][cc] == 0)
                                        || (rr - 1 < 0 || input[rr][cc - 1] == 0) || rr + 1 >= col
                                        || input[rr][cc + 1] == 0) {
                            captured = false;
                            break;
                        } else {
                            if (input[rr - 1][cc] == current && !visited[rr - 1][cc]) {
                                queue.add((rr - 1) * col + rr);
                                visited[rr - 1][cc] = true;
                                capturedList.add((rr - 1) * col + cc);
                            }
                            if (input[rr + 1][cc] == current && !visited[rr + 1][cc]) {
                                queue.add((rr + 1) * col + cc);
                                visited[rr + 1][cc] = true;
                                capturedList.add((rr + 1) * col + cc);
                            }
                            if (input[rr][cc - 1] == current && !visited[rr][cc - 1]) {
                                queue.add(rr * col + (cc - 1));
                                visited[rr][cc - 1] = true;
                                capturedList.add(rr * col + (cc - 1));
                            }
                            if (input[rr][cc + 1] == current && !visited[rr][cc + 1]) {
                                queue.add(rr * col + (cc + 1));
                                visited[rr][cc + 1] = true;
                                capturedList.add(rr * col + (cc + 1));
                            }
                        }
                    }
                    if (captured) {
                        op.addAll(capturedList);
                    }
                }
            }
        }

        return op;
    }

    public boolean isCaptured(int[][] input, int i, int j) {
        boolean captured = true;

        final int row = input.length;
        final int col = input[0].length;
        final boolean[][] visited = new boolean[row][col];

        final int current = input[i][j];
        final int opponent = (current == 1) ? 2 : 1;
        final Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i * col + j);
        visited[i][j] = true;
        final List<Integer> capturedList = new ArrayList<Integer>();
        capturedList.add(i * col + j);
        while (!queue.isEmpty()) {
            final int temp = queue.remove();
            final int rr = temp / col;
            final int cc = temp % col;

            if ((rr - 1 < 0 || input[rr - 1][cc] == 0) || (rr + 1 >= row || input[rr + 1][cc] == 0)
                            || (rr - 1 < 0 || input[rr][cc - 1] == 0) || rr + 1 >= col
                            || input[rr][cc + 1] == 0) {
                captured = false;
                break;
            } else {
                if (input[rr - 1][cc] == current && !visited[rr - 1][cc]) {
                    queue.add((rr - 1) * col + rr);
                    visited[rr - 1][cc] = true;
                    capturedList.add((rr - 1) * col + cc);
                }
                if (input[rr + 1][cc] == current && !visited[rr + 1][cc]) {
                    queue.add((rr + 1) * col + cc);
                    visited[rr + 1][cc] = true;
                    capturedList.add((rr + 1) * col + cc);
                }
                if (input[rr][cc - 1] == current && !visited[rr][cc - 1]) {
                    queue.add(rr * col + (cc - 1));
                    visited[rr][cc - 1] = true;
                    capturedList.add(rr * col + (cc - 1));
                }
                if (input[rr][cc + 1] == current && !visited[rr][cc + 1]) {
                    queue.add(rr * col + (cc + 1));
                    visited[rr][cc + 1] = true;
                    capturedList.add(rr * col + (cc + 1));
                }
            }
        }
        return captured;
    }
    
    
    public boolean isCapturedWithoutVisited(int[][] input, int i, int j) {
        boolean captured = true;

        final int row = input.length;
        final int col = input[0].length;

        final int current = input[i][j];
        final int opponent = (current == 1) ? 2 : 1;
        final Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i * col + j);
        input[i][j] = -1;
        final List<Integer> capturedList = new ArrayList<Integer>();
        capturedList.add(i * col + j);
        while (!queue.isEmpty()) {
            final int temp = queue.remove();
            final int rr = temp / col;
            final int cc = temp % col;

            if ((rr - 1 < 0 || input[rr - 1][cc] == 0) || (rr + 1 >= row || input[rr + 1][cc] == 0)
                            || (rr - 1 < 0 || input[rr][cc - 1] == 0) || rr + 1 >= col
                            || input[rr][cc + 1] == 0) {
                captured = false;
                break;
            } else {
                if (input[rr - 1][cc] == current && input[rr - 1][cc] != -1) {
                    queue.add((rr - 1) * col + rr);
                    input[rr - 1][cc] = -1;
                    capturedList.add((rr - 1) * col + cc);
                }
                if (input[rr + 1][cc] == current && input[rr + 1][cc] != -1) {
                    queue.add((rr + 1) * col + cc);
                    input[rr + 1][cc] = -1;
                    capturedList.add((rr + 1) * col + cc);
                }
                if (input[rr][cc - 1] == current && input[rr][cc - 1] != -1) {
                    queue.add(rr * col + (cc - 1));
                    input[rr][cc - 1] = -1;
                    capturedList.add(rr * col + (cc - 1));
                }
                if (input[rr][cc + 1] == current && input[rr][cc + 1] != -1) {
                    queue.add(rr * col + (cc + 1));
                    input[rr][cc + 1] = -1;
                    capturedList.add(rr * col + (cc + 1));
                }
            }
        }
        return captured;
    }
    
}

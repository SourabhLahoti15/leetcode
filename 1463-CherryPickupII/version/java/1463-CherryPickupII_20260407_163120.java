// Last updated: 4/7/2026, 4:31:20 PM
1class Solution {
2    public int solve(int r, int c1, int c2) {
3        if (c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols) {
4            return (int)-1e9;
5        }
6        if (r == rows - 1) {
7            if (c1 == c2) return grid[r][c1];
8            return grid[r][c1] + grid[r][c2];
9        }
10        if (dp[r][c1][c2] != -1) return dp[r][c1][c2];
11
12        int max = 0;
13
14        for (int d1 = -1; d1 <= 1; d1++) {
15            for (int d2 = -1; d2 <= 1; d2++) {
16                int val;
17                if (c1 == c2) val = grid[r][c1];
18                else val = grid[r][c1] + grid[r][c2];
19
20                val += solve(r + 1, c1 + d1, c2 + d2);
21                max = Math.max(max, val);
22            }
23        }
24
25        return dp[r][c1][c2] = max;
26    }
27    static int[][] grid;
28    static int rows;
29    static int cols;
30    static int[][][] dp;
31    public int cherryPickup(int[][] grid) {
32        this.grid = grid;
33        rows = grid.length;
34        cols = grid[0].length;
35        dp = new int[rows][cols][cols];
36        for (int[][] layer : dp)
37            for (int[] row : layer)
38                Arrays.fill(row, -1);
39
40        return solve(0, 0, cols - 1);
41    }
42}
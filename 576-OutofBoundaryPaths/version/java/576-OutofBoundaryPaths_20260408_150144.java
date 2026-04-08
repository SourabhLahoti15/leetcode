// Last updated: 4/8/2026, 3:01:44 PM
1class Solution {
2    public int solve(int i, int j, int moves) {
3        if (moves < 0) {
4            return 0;
5        }
6        if (i < 0 || i >= m || j < 0 || j >= n) {
7            return 1;
8        }
9        if (dp[i][j][moves] != -1) return dp[i][j][moves];
10        int bottom = solve(i+1, j, moves-1);
11        int top = solve(i-1, j, moves-1);
12        int right = solve(i, j+1, moves-1);
13        int left = solve(i, j-1, moves-1);
14        long ans = (long) bottom + top + left + right;
15        return dp[i][j][moves] = (int) (ans % mod);
16    }
17    int[][][] dp;
18    int mod = (int) 1e9 + 7;
19    int m;
20    int n;
21    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
22        this.m = m;
23        this.n = n;
24        this.dp = new int[m][n][maxMove+1];
25        for (int i=0; i<m; i++) {
26            for (int j=0; j<n; j++) {
27                Arrays.fill(dp[i][j], -1);
28            }
29        }
30        return solve(startRow, startColumn, maxMove);
31    }
32}
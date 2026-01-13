// Last updated: 1/13/2026, 11:44:21 AM
// memoization
1class Solution {
2    int[][] dp;
3    public int func(int[][] matrix, int i, int j, int prev) {
4        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
5            return 0;
6        }
7        if (prev != -1) {
8            if (prev >= matrix[i][j]) {
9                return 0;
10            }
11        }
12        if (dp[i][j] != -1) {
13            return dp[i][j];
14        }
15        int top = func(matrix, i-1, j, matrix[i][j]);
16        int bottom = func(matrix, i+1, j, matrix[i][j]);
17        int left = func(matrix, i, j-1, matrix[i][j]);
18        int right = func(matrix, i, j+1, matrix[i][j]);
19        return dp[i][j] = 1 + Math.max(top, Math.max(bottom, Math.max(left, right)));
20    }
21    public int longestIncreasingPath(int[][] matrix) {
22        int m = matrix.length;
23        int n = matrix[0].length;
24        dp = new int[m][n];
25        for (int i=0; i<m; i++) {
26            Arrays.fill(dp[i], -1);
27        }
28        int max = 0;
29        for (int i=0; i<m; i++) {
30            for (int j=0; j<n; j++) {
31                max = Math.max(max, func(matrix, i, j, -1));
32            }
33        }
34        return max;
35    }
36}
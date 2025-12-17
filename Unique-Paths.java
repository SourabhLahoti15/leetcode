1class Solution {
2    int[][] dp;
3    public int func(int i, int j, int m, int n) {
4        if (i<0 || j<0 || i>m-1 || j>n-1) {
5            return 0;
6        }
7        if (i == m-1 && j == n-1) {
8            return 1;
9        }
10        if (dp[i][j] != -1) {
11            return dp[i][j];
12        }
13        dp[i][j] = func(i+1, j, m, n) + func(i, j+1, m, n);
14        return dp[i][j];
15    }
16    public int uniquePaths(int m, int n) {
17        dp = new int[m][n];
18        for (int i=0; i<m; i++) {
19            Arrays.fill(dp[i], -1);
20        }
21        return func(0, 0, m, n);
22    }
23}
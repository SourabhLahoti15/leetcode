1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp = new int[m][n];
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                if (i == 0 && j == 0) {
7                    dp[0][0] = 1;
8                    continue;
9                }
10                int up = 0;
11                int left = 0;
12                if (i != 0) {
13                    up = dp[i-1][j];
14                }
15                if (j != 0) {
16                    left = dp[i][j-1];
17                }
18                dp[i][j] = up + left;
19            }
20        }
21        return dp[m-1][n-1];
22    }
23}
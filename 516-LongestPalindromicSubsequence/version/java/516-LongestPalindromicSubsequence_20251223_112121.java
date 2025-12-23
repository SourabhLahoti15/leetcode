// Last updated: 12/23/2025, 11:21:21 AM
1class Solution {
2    static int[][] dp;
3    public int func(String s, int i, int j) {
4        if (i == j) return 1;
5        if (i > j) return 0;
6        if (dp[i][j] != -1) return dp[i][j];
7        if (s.charAt(i) == s.charAt(j)) {
8            dp[i][j] = 2 + func(s, i+1, j-1);
9        } else {
10            dp[i][j] = Math.max(func(s, i+1, j), func(s, i, j-1));
11        }
12        return dp[i][j];
13    }
14    public int longestPalindromeSubseq(String s) {
15        int n = s.length();
16        dp = new int[n][n];
17        for (int i = 0; i < n; i++) {
18            for (int j = 0; j < n; j++) {
19                dp[i][j] = -1;
20            }
21        }
22        return func(s, 0, s.length()-1);
23    }
24}
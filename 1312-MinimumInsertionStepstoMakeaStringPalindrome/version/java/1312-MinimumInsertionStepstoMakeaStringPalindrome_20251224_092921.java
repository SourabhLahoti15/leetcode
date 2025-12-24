// Last updated: 12/24/2025, 9:29:21 AM
1class Solution {
2    int[][] dp;
3    public int func(String s, int i, int j) {
4        if (i >= j) {
5            return 0;
6        }
7        if (dp[i][j] != -1) return dp[i][j];
8        if (s.charAt(i) == s.charAt(j)) {
9            dp[i][j] = func(s, i+1, j-1);
10        } else {
11            dp[i][j] = 1 + Math.min(func(s, i+1, j), func(s, i, j-1));
12        }
13        return dp[i][j];
14    }
15    public int minInsertions(String s) {
16        int n = s.length();
17        dp = new int[n][n];
18        for (int i=0; i<n; i++) {
19            Arrays.fill(dp[i], -1);
20        }
21        return func(s, 0, s.length()-1);
22    }
23}
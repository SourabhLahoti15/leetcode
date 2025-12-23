// Last updated: 12/23/2025, 9:39:39 AM
1class Solution {
2    int[][] dp;
3    public int func(String text1, String text2, int i, int j) {
4        if (i>=text1.length() || j>=text2.length()) {
5            return 0;
6        }
7        if (dp[i][j] != -1) return dp[i][j];
8        if (text1.charAt(i) == text2.charAt(j)) {
9            dp[i][j] = 1 + func(text1, text2, i+1, j+1);
10            return dp[i][j];
11        } else {
12            dp[i][j] = Math.max(func(text1, text2, i+1, j), func(text1, text2, i, j+1));
13            return dp[i][j];
14        }
15    }
16    public int longestCommonSubsequence(String text1, String text2) {
17        dp = new int[text1.length()][text2.length()];
18        for (int i=0; i<text1.length(); i++) {
19            Arrays.fill(dp[i], -1);
20        }
21        return func(text1, text2, 0, 0);
22    }
23}
24
// Last updated: 12/24/2025, 11:14:39 AM
1class Solution {
2    int[][] dp;
3    public int func(String word1, String word2, int i, int j) {
4        if (i >= word1.length() && j >= word2.length()) return 0;
5        if (dp[i][j] != -1) return dp[i][j];
6        if (i >= word1.length()) {
7            return dp[i][j] = 1 + func(word1, word2, i, j+1); 
8        } else if (j >= word2.length()) {
9            return dp[i][j] = 1 + func(word1, word2, i+1, j);
10        }
11        if (word1.charAt(i) == word2.charAt(j)) {
12            return dp[i][j] = func(word1, word2, i+1, j+1);
13        } else {
14            int replace = 1 + func(word1, word2, i+1, j+1);
15            int delete = 1 + Math.min(func(word1, word2, i+1, j), func(word1, word2, i, j+1));
16            return dp[i][j] = Math.min(replace, delete);
17        }
18    }
19    public int minDistance(String word1, String word2) {
20        int m = word1.length();
21        int n = word2.length();
22        dp = new int[m+1][n+1];
23        for (int i=0; i<=m; i++) {
24            for (int j=0; j<=n; j++) {
25                dp[i][j] = -1;
26            }
27        }
28        return func(word1, word2, 0, 0);
29    }
30}
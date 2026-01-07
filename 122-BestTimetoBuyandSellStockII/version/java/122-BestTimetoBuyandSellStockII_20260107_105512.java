// Last updated: 1/7/2026, 10:55:12 AM
// tabulation
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int[][] dp = new int[n][2];
5        dp[0][0] = 0;
6        dp[0][1] = -prices[0];
7        for (int i=1; i<n; i++) {
8            dp[i][0] = Math.max(
9                dp[i-1][1] + prices[i],
10                dp[i-1][0]
11            );
12            dp[i][1] = Math.max(
13                dp[i-1][0] - prices[i],
14                dp[i-1][1]
15            );
16        }
17        return dp[n-1][0];
18    }
19}
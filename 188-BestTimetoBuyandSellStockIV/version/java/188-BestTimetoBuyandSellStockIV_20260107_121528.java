// Last updated: 1/7/2026, 12:15:28 PM
// memoization
1class Solution {
2    static int[][][] dp;
3    public int func(int[] prices, int i, int limit, boolean canBuy) {
4        if (i >= prices.length || limit <= 0) {
5            return 0;
6        }
7        int j = 0;
8        if (canBuy) j = 1;
9        if (dp[i][j][limit] != -1) return dp[i][j][limit];
10        if (canBuy) {
11            dp[i][j][limit] = Math.max(func(prices, i+1, limit, false) - prices[i], func(prices, i+1, limit, true));
12        } else {
13            dp[i][j][limit] = Math.max(func(prices, i+1, limit-1, true) + prices[i], func(prices, i+1, limit, false));
14        }
15        return dp[i][j][limit];
16    }
17    public int maxProfit(int k, int[] prices) {
18        int n = prices.length;
19        dp = new int[n][2][k+1];
20        for (int i=0; i<n; i++) {
21            for (int j=0; j<2; j++) {
22                Arrays.fill(dp[i][j], -1);
23            }
24        }
25        return func(prices, 0, k, true);
26    }
27}
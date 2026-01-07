// Last updated: 1/7/2026, 11:59:07 AM
// memoization
1class Solution {
2    static int[][] dp;
3    public int func(int[] prices, int i, boolean canBuy) {
4        if (i >= prices.length) {
5            return 0;
6        }
7        int j = 0;
8        if (canBuy) j = 1;
9        if (dp[i][j] != -1) return dp[i][j];
10        if (canBuy) {
11            dp[i][j] = Math.max(func(prices, i+1, false) - prices[i], func(prices, i+1, true));
12        } else {
13            dp[i][j] = Math.max(func(prices, i+2, true) + prices[i], func(prices, i+1, false));
14        }
15        return dp[i][j];
16    }
17    public int maxProfit(int[] prices) {
18        int n = prices.length;
19        dp = new int[n][2];
20        for (int i=0; i<n; i++) {
21            Arrays.fill(dp[i], -1);
22        }
23        return func(prices, 0, true);
24    }
25}
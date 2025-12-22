// Last updated: 12/22/2025, 10:17:10 AM
1class Solution {
2    int[][] dp;
3    public int func(int[] coins, int amount, int idx) {
4        if (amount == 0) return 0;
5        if (idx == coins.length || amount < 0) {
6            return Integer.MAX_VALUE;
7        }
8        if (dp[idx][amount] != -1) {
9            return dp[idx][amount];
10        }
11        int take = func(coins, amount - coins[idx], idx);
12        if (take != Integer.MAX_VALUE) {
13            take += 1;
14        }
15        int skip = func(coins, amount, idx+1);
16        dp[idx][amount] = Math.min(take, skip);
17        return dp[idx][amount];
18    }
19    public int coinChange(int[] coins, int amount) {
20        dp = new int[coins.length][amount + 1];
21        for (int i = 0; i < coins.length; i++) {
22            Arrays.fill(dp[i], -1);
23        }
24
25        int ans = func(coins, amount, 0);
26        return ans == Integer.MAX_VALUE ? -1 : ans;
27    }
28}
// Last updated: 12/22/2025, 10:40:36 AM
1class Solution {
2    int[][] dp;
3    public int func(int amount, int[] coins, int idx) {
4        if (idx == coins.length || amount < 0) {
5            return 0;
6        }
7        if (amount == 0) {
8            return 1;
9        }
10        if (dp[idx][amount] != -1) return dp[idx][amount];
11        int take = func(amount-coins[idx], coins, idx);
12        int skip = func(amount, coins, idx+1);
13        dp[idx][amount] = take+skip;
14        return dp[idx][amount];
15    }
16    public int change(int amount, int[] coins) {
17        dp = new int[coins.length][amount+1];
18        for (int i=0; i<coins.length; i++) {
19            Arrays.fill(dp[i], -1);
20        }
21        return func(amount, coins, 0);
22    }
23}
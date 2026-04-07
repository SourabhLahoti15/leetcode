// Last updated: 4/7/2026, 10:48:32 AM
1class Solution {
2    public int solve(int i, int n, int p) {
3        if (n < 0) return 0;
4        p = Math.min(p, s_minProfit);
5        if (i >= s_group.length) {
6            if (n >= 0 && p >= s_minProfit) {
7                return 1;
8            } else {
9                return 0;
10            }
11        }
12        if (dp[i][n][p] != -1) {
13            return dp[i][n][p];
14        }
15        int take = solve(i+1, n - s_group[i], p + s_profit[i]);
16        int skip = solve(i+1, n, p);
17        return dp[i][n][p] = (take + skip) % mod;
18    }
19    static final int mod = 1_000_000_007;
20    static int[][][] dp;
21    static int[] s_group;
22    static int[] s_profit;
23    static int s_minProfit;
24    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
25        s_group = group;
26        s_profit = profit;
27        s_minProfit = minProfit;
28        int len = group.length;
29        dp = new int[101][101][101];
30        for (int i=0; i<101; i++) {
31            for (int j=0; j<101; j++) {
32                Arrays.fill(dp[i][j], -1);
33            }
34        }
35        return solve(0, n, 0);
36    }
37}
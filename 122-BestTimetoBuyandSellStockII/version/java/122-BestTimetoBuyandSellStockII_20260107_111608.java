// Last updated: 1/7/2026, 11:16:08 AM
// space optimization
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int prevsell = 0;
5        int prevbuy = -prices[0];
6        for (int i=1; i<n; i++) {
7            prevsell = Math.max(
8                prevbuy + prices[i],
9                prevsell
10            );
11            prevbuy = Math.max(
12                prevsell - prices[i],
13                prevbuy
14            );
15        }
16        return prevsell;
17    }
18}
// Last updated: 4/15/2026, 3:42:59 PM
1class Solution {
2    public int[] countBits(int n) {
3        int[] ans = new int[n+1];
4        for (int i=1; i<=n; i++) {
5            if (i % 2 == 0) {
6                ans[i] = ans[i/2];
7            } else {
8                ans[i] = ans[i/2] + 1;
9            }
10        }
11        return ans;
12    }
13}
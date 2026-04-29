// Last updated: 4/29/2026, 11:37:04 PM
1class Solution {
2    Long dp[][][];
3
4    public long maximumScore(int[][] grid) {
5        int n = grid.length;
6        dp = new Long[n + 1][n + 1][n + 1];
7        return solve(n, 0, 0, 0, grid);
8    }
9
10    private long solve(int n, int c, int prev1, int prev2, int grid[][]) {
11        if (c >= n)
12            return 0;
13        if (dp[c][prev1][prev2] != null)
14            return dp[c][prev1][prev2];
15
16        long s2 = 0;
17        for (int i = 0; i < prev2; i++) {
18            s2 += grid[i][c];
19
20        }
21
22        long ans = s2 + solve(n, c + 1, 0, prev1, grid);
23
24        long s1 = 0;
25
26        if (c + 1 < n) {
27            for (int i = prev1; i < n; i++) {
28                s1 += grid[i][c];
29
30                ans = Math.max(ans, s1 + solve(n, c + 1, i + 1, 0, grid));
31            }
32        }
33
34        for (int i = 0; i < n; i++) {
35            if (i < prev2) {
36                s2 -= grid[i][c];
37            }
38
39            ans = Math.max(ans, s2 + solve(n, c + 1, 0, i + 1, grid));
40        }
41
42        return dp[c][prev1][prev2] = ans;
43
44    }
45}
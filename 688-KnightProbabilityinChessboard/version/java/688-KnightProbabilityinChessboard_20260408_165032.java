// Last updated: 4/8/2026, 4:50:32 PM
1class Solution {
2    public double solve(int i, int j, int moves) {
3        if (i < 0 || i >= n || j < 0 || j >= n) {
4            return 0;
5        }
6        if (moves == 0) return 1;
7        if (dp[i][j][moves] != -1) return dp[i][j][moves];
8        double upleft = solve(i-2, j-1, moves-1);
9        double upright = solve(i-2, j+1, moves-1);
10
11        double rightup = solve(i-1, j+2, moves-1);
12        double rightdown = solve(i+1, j+2, moves-1);
13
14        double downright = solve(i+2, j+1, moves-1);
15        double downleft = solve(i+2, j-1, moves-1);
16
17        double leftup = solve(i-1, j-2, moves-1);
18        double leftdown = solve(i+1, j-2, moves-1);
19        return dp[i][j][moves] = (upleft + upright + rightup + rightdown + downright + downleft + leftup + leftdown)/8.0;
20    }
21    int n;
22    int k;
23    double[][][] dp;
24    public double knightProbability(int n, int k, int row, int column) {
25        this.n = n;
26        this.k = k;
27        dp = new double[n][n][k+1];
28        for (int i=0; i<n; i++) {
29            for (int j=0; j<n; j++) {
30                Arrays.fill(dp[i][j], -1);
31            }
32        }
33        return solve(row, column, k);
34    }
35}
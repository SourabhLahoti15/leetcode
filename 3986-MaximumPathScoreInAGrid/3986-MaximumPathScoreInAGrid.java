// Last updated: 6/14/2026, 10:04:35 AM
class Solution {
    public int func(int[][] grid, int i, int j, int cost, int k) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j][cost] != -1) return dp[i][j][cost];
        int val = grid[i][j];
        int newCost = cost + (val == 0 ? 0 : 1);
        if (newCost > k) return Integer.MIN_VALUE;
        if (i == grid.length-1 && j == grid[0].length-1) {
            return dp[i][j][cost] = val;
        }
        int right = func(grid, i, j+1, newCost, k);
        int down = func(grid, i+1, j, newCost, k);
        int best = Math.max(right, down);
        if (best == Integer.MIN_VALUE) {
            return dp[i][j][cost] = Integer.MIN_VALUE;
        }
        return dp[i][j][cost] = val + best;
    }
    int[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][k+1];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ans = func(grid, 0, 0, 0, k);
        if (ans == Integer.MIN_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }
}
// Last updated: 12/17/2025, 10:51:41 AM
class Solution {
    int[][] dp;
    public int func(int[][] grid, int i, int j) {
        if (j<0 || j>=grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length-1) {
            return grid[i][j];
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int clm=0; clm<grid[0].length; clm++) {
            if (clm != j) {
                int ans = func(grid, i+1, clm);
                if (ans < min) {
                    min = ans;
                }
            }
        }
        dp[i][j] = grid[i][j] + min;
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j<grid[0].length; j++) {
            int ans = func(grid, 0, j);
            if (ans < min) {
                min = ans;
            }
        }
        return min;
    }
}
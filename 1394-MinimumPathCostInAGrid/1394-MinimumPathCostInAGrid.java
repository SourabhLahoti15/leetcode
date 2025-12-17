// Last updated: 12/17/2025, 10:51:39 AM
class Solution {
    int[][] dp;
    public int func(int[][] grid, int[][] moveCost, int i, int j) {
        if (i == grid.length-1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) return dp[i][j];
        int best = Integer.MAX_VALUE;
        for (int jval = 0; jval<grid[0].length; jval++) {
            int cost = grid[i][j] + moveCost[grid[i][j]][jval] + func(grid, moveCost, i+1, jval);
            best = Math.min(best, cost);
        }
        dp[i][j] = best;
        return best;
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int best = Integer.MAX_VALUE;
        dp = new int[m][n];
        for (int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int j=0; j<n; j++) {
            best = Math.min(best, func(grid, moveCost, 0, j));
        }
        return best;
    }
}
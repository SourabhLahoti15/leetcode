// Last updated: 12/17/2025, 10:54:06 AM
class Solution {
    int[][] dp;
    public int func(int[][] obstacleGrid, int i, int j) {
        if (i<0 || j<0 || i>=obstacleGrid.length || j>=obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        obstacleGrid[i][j] = 1;
        dp[i][j] = func(obstacleGrid, i+1, j) + func(obstacleGrid, i, j+1);
        obstacleGrid[i][j] = 0;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(obstacleGrid, 0, 0);
    }
}
// Last updated: 12/17/2025, 10:51:50 AM
class Solution {
    int[][] dp;
    public int func(int[][] matrix, int i, int j) {
        if (j<0 || j>=matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == matrix.length-1) {
            return matrix[i][j];
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        dp[i][j] = matrix[i][j] + Math.min(Math.min(func(matrix, i+1, j-1), func(matrix, i+1, j)), func(matrix, i+1, j+1));
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j<matrix[0].length; j++) {
            int ans = func(matrix, 0, j);
            if (ans < min) {
                min = ans;
            }
        }
        return min;
    }
}
// Last updated: 12/17/2025, 10:53:50 AM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int row=1; row<triangle.size(); row++) {
            for (int i=0; i<triangle.get(row).size(); i++) {
                int top = dp[row-1][i];
                int topleft = Integer.MAX_VALUE;
                if (i-1 >= 0) {
                    topleft = dp[row-1][i-1];
                }
                dp[row][i] = triangle.get(row).get(i) + Math.min(top, topleft);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            if (dp[n-1][i] < min) {
                min = dp[n-1][i];
            }
        }
        return min;
    }
}

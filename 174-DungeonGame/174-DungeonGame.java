// Last updated: 12/17/2025, 10:53:34 AM
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int healthstart = 1;
        int healthend = (int) (4 * Math.pow(10, 7));
        int[][] dp = new int[m][n];
        while (healthstart < healthend) {
            int minhealth = healthstart + (healthend - healthstart)/2;
            for (int i=0; i<m; i++) {
                Arrays.fill(dp[i], -1);
            }
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = minhealth + dungeon[i][j];
                    } else {
                        int top = i > 0 ? dp[i - 1][j] : Integer.MIN_VALUE;
                        int left = j > 0 ? dp[i][j - 1] : Integer.MIN_VALUE;
                        int best = Math.max(top, left);

                        if (best != Integer.MIN_VALUE) {
                            dp[i][j] = best + dungeon[i][j];
                        }
                    }
                    if (dp[i][j] <= 0) {
                        dp[i][j] = Integer.MIN_VALUE;
                    }
                }
            }
            if (dp[m-1][n-1] > 0) {
                healthend = minhealth;
            } else {
                healthstart = minhealth + 1;
            }
        }
        return healthstart;
    }
}
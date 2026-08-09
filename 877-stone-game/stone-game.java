class Solution {
    int[][] dp;
    public int solve(int[] piles, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        int take_i = piles[i] + Math.min(solve(piles, i+2, j), solve(piles, i+1, j-1));
        int take_j = piles[j] + Math.min(solve(piles, i, j-2), solve(piles, i+1, j-1));
        return dp[i][j] = Math.max(take_i, take_j);
    }
    public boolean stoneGame(int[] piles) {
        dp = new int[501][501];
        for (int[] row : dp) Arrays.fill(row, -1);
        int n = piles.length;
        int total = 0;
        for (int pile : piles) total += pile;
        int alice = solve(piles, 0, n-1);
        return alice > total/2;
    }
}
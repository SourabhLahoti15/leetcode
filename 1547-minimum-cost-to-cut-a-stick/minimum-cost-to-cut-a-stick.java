class Solution {
    int[][] dp;
    int[] newcuts;
    public int func(int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k=i; k<=j; k++) {
            int cost = (newcuts[j+1] - newcuts[i-1]) + func(i, k-1) + func(k+1, j);
            minCost = Math.min(minCost, cost);
        }
        return dp[i][j] = minCost;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        newcuts = new int[m+2];
        newcuts[0] = 0;
        newcuts[m+1] = n;
        for (int i=0; i<m; i++) {
            newcuts[i+1] = cuts[i];
        }
        dp = new int[m+2][m+2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(1, m);
    }
}
class Solution {
    int[] dp;
    int n;
    int[] costs;
    public int solve(int step) {
        if (step == n) return 0;
        if (dp[step] != -1) return dp[step];
        int one = costs[step] + (int) Math.pow(step+1 - step, 2) + solve(step+1);
        int two = (step + 2 > n) ? Integer.MAX_VALUE : costs[step+1] + (int) Math.pow(step+2 - step, 2) + solve(step+2);
        int three = (step + 3 > n) ? Integer.MAX_VALUE : costs[step+2] + (int) Math.pow(step+3 - step, 2) + solve(step+3);
        return dp[step] = Math.min(
            one,
            Math.min(two, three)
        );
    }
    public int climbStairs(int n, int[] costs) {
        this.n = n;
        this.costs = costs;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0);
    }
}
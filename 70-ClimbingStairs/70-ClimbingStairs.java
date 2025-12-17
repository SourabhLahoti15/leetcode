// Last updated: 12/17/2025, 10:54:04 AM
import java.util.Arrays;
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return func(n, dp);
    }
    public int func(int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        dp[n] = func(n-1, dp) + func(n-2, dp);
        return dp[n];
    }
}
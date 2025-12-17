// Last updated: 12/17/2025, 10:51:40 AM
import java.util.Arrays;
class Solution {
    public int func(int[] dp, int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = func(dp, n-1) + func(dp, n-2) + func(dp, n-3);
        return dp[n];
    }
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return func(dp, n);
    }
}
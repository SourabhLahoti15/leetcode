// Last updated: 12/17/2025, 10:53:22 AM
import java.util.Arrays;
class Solution {
    int[] dp;
    public int func(int[] nums, int idx) {
        if (idx < 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int rob = nums[idx] + func(nums, idx - 2);
        int skip = func(nums, idx - 1);
        dp[idx] = Math.max(rob, skip);
        return dp[idx];
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return func(nums, nums.length-1);
    }
}
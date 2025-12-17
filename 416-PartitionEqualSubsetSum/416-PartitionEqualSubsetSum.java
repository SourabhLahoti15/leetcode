// Last updated: 12/17/2025, 10:52:33 AM
class Solution {
    static int[][] dp;
    public boolean func(int nums[], int idx, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        if (idx >= nums.length) {
            return false;
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum] == 1;
        }
        boolean ans = (func(nums, idx+1, sum-nums[idx]) || func(nums, idx+1, sum));
        dp[idx][sum] = ans ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2 != 0) return false;
        int halfsum = sum/2;
        dp = new int[nums.length][halfsum + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(nums, 0, halfsum);
    }
}
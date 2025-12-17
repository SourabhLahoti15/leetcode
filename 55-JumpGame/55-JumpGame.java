// Last updated: 12/17/2025, 10:54:11 AM
class Solution {
    int[] dp;
    public boolean func(int[] nums, int idx) {
        if (idx == nums.length-1) {
            return true;
        }
        if (idx >= nums.length) {
            return false;
        }
        if (nums[idx] == 0) {
            return false;
        }
        if (dp[idx] == 1) {
            return true;
        } else if (dp[idx] == 0) {
            return false;
        }
        for (int j=1; j<=nums[idx]; j++) {
            if (func(nums, idx+j)) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return func(nums, 0);
    }
}
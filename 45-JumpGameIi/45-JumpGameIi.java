// Last updated: 12/17/2025, 10:54:17 AM
class Solution {
    int[] dp;
    public int func(int[] nums, int idx) {
        if (idx == nums.length-1) {
            return 0;
        }
        if (idx >= nums.length) {
            return Integer.MAX_VALUE;
        }
        if (nums[idx] == 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int min = Integer.MAX_VALUE;
        for (int j=1; j<=nums[idx]; j++) {
            int val = func(nums, idx+j);
            if (val != Integer.MAX_VALUE) {
                min = Math.min(min, val+1);
            }
        }
        dp[idx] = min;
        return dp[idx];
    }
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return func(nums, 0);
    }
}
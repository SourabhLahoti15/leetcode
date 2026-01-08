// Last updated: 1/8/2026, 10:10:53 AM
// memoization
1class Solution {
2    static int[][] dp;
3    public int func(int[] nums, int previdx, int idx) {
4        if (idx >= nums.length) {
5            return 0;
6        }
7        if (dp[previdx+1][idx] != -1) {
8            return dp[previdx+1][idx];
9        }
10        int skip = func(nums, previdx, idx + 1);
11        int take = 0;
12        if (previdx == -1 || nums[previdx] < nums[idx]) {
13            take = 1 + func(nums, idx, idx + 1);
14        } 
15        return dp[previdx+1][idx] = Math.max(take, skip);
16    }
17    public int lengthOfLIS(int[] nums) {
18        int n = nums.length;
19        dp = new int[n][n];
20        for (int i=0; i<n; i++) {
21            Arrays.fill(dp[i], -1);
22        }
23        return func(nums, -1, 0);
24    }
25}
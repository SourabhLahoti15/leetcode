// Last updated: 12/22/2025, 12:06:47 PM
1class Solution {
2    int[][] dp;
3    public int func(List<Integer> nums, int target, int idx) {
4        if (target == 0) {
5            return 0;
6        }
7        if (idx == nums.size() || target < 0) {
8            return Integer.MIN_VALUE;
9        }
10        if (dp[idx][target] != -1) {
11            return dp[idx][target];
12        }
13        int take = func(nums, target-nums.get(idx), idx+1) + 1;
14        int skip = func(nums, target, idx+1);
15        dp[idx][target] = Math.max(take, skip);
16        return dp[idx][target];
17    }
18
19    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
20        dp = new int[nums.size()][target+1];
21        for (int i=0; i<nums.size(); i++) {
22            Arrays.fill(dp[i], -1);
23        }
24        int ans = func(nums, target, 0);
25        if (ans < 0) return -1;
26        return ans;
27    }
28}
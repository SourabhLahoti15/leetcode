// Last updated: 12/23/2025, 11:58:13 AM
// top-down, Memoization
1class Solution {
2    int[][] dp;
3    static int ans;
4    public int func(int[] nums1, int[] nums2, int i, int j) {
5        if (i >= nums1.length || j >= nums2.length) return 0;
6        if (dp[i][j] != -1) return dp[i][j];
7        if (nums1[i] == nums2[j]) {
8            dp[i][j] = 1 + func(nums1, nums2, i+1, j+1);
9            ans = Math.max(ans, dp[i][j]);
10        } else {
11            dp[i][j] = 0;
12        }
13        return dp[i][j];
14    }
15    public int findLength(int[] nums1, int[] nums2) {
16        int m = nums1.length;
17        int n = nums2.length;
18        dp = new int[m][n];
19        for (int i=0; i<m; i++) {
20            Arrays.fill(dp[i], -1);
21        }
22        ans = 0;
23        for (int i = 0; i < nums1.length; i++) {
24            for (int j = 0; j < nums2.length; j++) {
25                func(nums1, nums2, i, j);
26            }
27        }
28        return ans;
29    }
30}
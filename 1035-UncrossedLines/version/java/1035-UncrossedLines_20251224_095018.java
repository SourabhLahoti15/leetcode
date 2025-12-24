// Last updated: 12/24/2025, 9:50:18 AM
1class Solution {
2    int[][] dp;
3    public int func(int[] nums1, int[] nums2, int i, int j) {
4        if (i >= nums1.length || j >= nums2.length) {
5            return 0;
6        }
7        if (dp[i][j] != -1) {
8            return dp[i][j];
9        }
10        if (nums1[i] == nums2[j]) {
11            dp[i][j] = 1 + func(nums1, nums2, i+1, j+1);
12        } else {
13            dp[i][j] = Math.max(func(nums1, nums2, i+1, j), func(nums1, nums2, i, j+1));
14        }
15        return dp[i][j];
16    }
17    public int maxUncrossedLines(int[] nums1, int[] nums2) {
18        int m = nums1.length;
19        int n = nums2.length;
20        dp = new int[m][n];
21        for (int i=0; i<m; i++) {
22            for (int j=0; j<n; j++) {
23                dp[i][j] = -1;
24            }
25        }
26        return func(nums1, nums2, 0, 0);
27    }
28}
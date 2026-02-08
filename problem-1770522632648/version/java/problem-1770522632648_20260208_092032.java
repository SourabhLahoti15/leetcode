// Last updated: 2/8/2026, 9:20:32 AM
1class Solution {
2    long[][][] dp;
3    int n;
4    int m;
5
6    public long func(int[] nums1, int[] nums2, int i, int j, int k) {
7        if (k == 0) return 0;
8        if (i >= n || j >= m) {
9            return Long.MIN_VALUE/2;
10        }
11        if (dp[i][j][k] != Long.MIN_VALUE) return dp[i][j][k];
12        long score = (long) nums1[i] * nums2[j];        
13        long take = score + func(nums1, nums2, i+1, j+1, k-1);
14        long skip = Math.max(
15                func(nums1, nums2, i, j+1, k),
16                func(nums1, nums2, i+1, j, k)                
17            );
18        return dp[i][j][k] = Math.max(take, skip);
19    }
20
21    public long maxScore(int[] nums1, int[] nums2, int k) {
22        n = nums1.length;
23        m = nums2.length;
24        dp = new long[n][m][k + 1];
25        for (int i = 0; i < n; i++) {
26            for (int j = 0; j < m; j++) {
27                Arrays.fill(dp[i][j], Long.MIN_VALUE);
28            }
29        }
30        return func(nums1, nums2, 0, 0, k);
31    }
32}
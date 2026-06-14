// Last updated: 6/14/2026, 10:04:07 AM
class Solution {
    long[][][] dp;
    int n;
    int m;

    public long func(int[] nums1, int[] nums2, int i, int j, int k) {
        if (k == 0) return 0;
        if (i >= n || j >= m) {
            return Long.MIN_VALUE/2;
        }
        if (dp[i][j][k] != Long.MIN_VALUE) return dp[i][j][k];
        long score = (long) nums1[i] * nums2[j];        
        long take = score + func(nums1, nums2, i+1, j+1, k-1);
        long skip = Math.max(
                func(nums1, nums2, i, j+1, k),
                func(nums1, nums2, i+1, j, k)                
            );
        return dp[i][j][k] = Math.max(take, skip);
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        n = nums1.length;
        m = nums2.length;
        dp = new long[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Long.MIN_VALUE);
            }
        }
        return func(nums1, nums2, 0, 0, k);
    }
}
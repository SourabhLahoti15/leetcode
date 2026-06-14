// Last updated: 6/14/2026, 10:04:34 AM
class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] maxPrefix = new int[n];
        maxPrefix[0] = nums[0];
        for (int i=1; i<n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i-1], nums[i]);
        }
        int[] minSuffix = new int[n];
        minSuffix[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--) {
            minSuffix[i] = Math.min(minSuffix[i+1], nums[i]);
        }
        int[] ans = new int[n];
        ans[n-1] = maxPrefix[n-1];
        for (int i=n-2; i>=0; i--) {
            if (maxPrefix[i] > minSuffix[i+1]) {
                ans[i] = ans[i+1];
            } else {
                ans[i] = maxPrefix[i];
            }
        }
        return ans;
    }
}
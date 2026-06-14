// Last updated: 6/14/2026, 10:04:03 AM
class Solution {
    public int dominantIndices(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        int ans = 0;
        for (int i=0; i<nums.length-1; i++) {
            sum -= nums[i];
            n--;
            if (nums[i] > (sum/n)) {
                ans++;
            }
        }
        return ans;
    }
}
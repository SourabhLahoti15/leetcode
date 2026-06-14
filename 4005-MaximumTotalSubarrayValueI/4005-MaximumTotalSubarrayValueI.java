// Last updated: 6/14/2026, 10:04:32 AM
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return 1L*(max-min)*k;
    }
}
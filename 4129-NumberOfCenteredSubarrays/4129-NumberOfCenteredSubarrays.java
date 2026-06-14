// Last updated: 6/14/2026, 10:04:17 AM
class Solution {
    public int centeredSubarrays(int[] nums) {
        int centered = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int sum = Arrays.stream(nums, i, j+1).sum();
                for (int k=i; k<=j; k++) {
                    if (nums[k] == sum) {
                        centered++;
                        break;
                    }
                }
            }
        }
        return centered;
    }
}
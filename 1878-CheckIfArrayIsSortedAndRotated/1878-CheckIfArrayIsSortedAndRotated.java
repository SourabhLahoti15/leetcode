// Last updated: 12/17/2025, 10:51:19 AM
class Solution {
    public boolean check(int[] nums) {
        int drop = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]>nums[(i+1)%nums.length]) {
                drop++;
            }
        }
        return drop<=1;
    }
}
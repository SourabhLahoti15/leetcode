// Last updated: 6/14/2026, 10:04:39 AM
class Solution {
    public boolean isTrionic(int[] nums) {
        int p = -1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                p = i;
            } else {
                break;
            }
        }
        if (p == -1) return false;
        int q = -1;
        for (int i=p+1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                q = i;
            } else {
                break;
            }
        }
        if (q == -1 || q == nums.length-1) return false;
        for (int i=q+1; i<nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}
// Last updated: 12/17/2025, 10:52:29 AM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int localmax = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if (nums[i] == 1) {
                localmax++;
            } else {
                if (localmax > max) {
                    max = localmax;
                }
                localmax = 0;
            }
            if (localmax > max) {
                max = localmax;
            }
        }
        return max;
    }
}
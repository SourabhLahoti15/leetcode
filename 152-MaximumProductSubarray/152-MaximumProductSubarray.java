// Last updated: 12/17/2025, 10:53:42 AM
class Solution {
    public int maxProduct(int[] nums) {
        int minSoFar = nums[0];
        int maxSoFar = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            int current = nums[i];
            int temp = Math.max(current, Math.max(current*maxSoFar, current*minSoFar));
            minSoFar = Math.min(current, Math.min(current*maxSoFar, current*minSoFar));
            maxSoFar = temp;
            result = Math.max(result, Math.max(minSoFar, maxSoFar));
        }
        return result;
    }
}
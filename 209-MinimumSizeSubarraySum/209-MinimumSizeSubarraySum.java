// Last updated: 12/17/2025, 10:53:19 AM
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0;
        int e = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(e<nums.length){
            sum += nums[e];
            while (sum >= target) {
                minLen = Math.min(minLen, e - s + 1);
                sum -= nums[s]; 
                s++;
            }
            e++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
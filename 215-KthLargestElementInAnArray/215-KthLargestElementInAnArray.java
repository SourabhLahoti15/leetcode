// Last updated: 12/17/2025, 10:53:16 AM
import java.util.Arrays;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
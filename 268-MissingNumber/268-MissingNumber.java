// Last updated: 12/17/2025, 10:53:02 AM
import java.util.Arrays;
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int check = 0;
        while (check<len) {
            if (check!=nums[check]) {
                return check;
            }
            check++;
        }
        return nums.length;
    }
}
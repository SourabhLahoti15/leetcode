// Last updated: 12/17/2025, 10:51:03 AM
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 3 == 0) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }
}
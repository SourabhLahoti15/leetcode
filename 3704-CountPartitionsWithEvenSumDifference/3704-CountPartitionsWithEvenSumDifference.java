// Last updated: 12/17/2025, 10:50:57 AM
class Solution {
    public int sum(int i, int[] nums) {
        int sum = 0;
        for (int p=0; p<=i; p++) {
            sum += nums[p];
        }
        return sum;
    }
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        int count = 0;
        for (int i=0; i<nums.length-1; i++) {
            int sum_i = sum(i, nums);
            int sum_i1 = sum - sum_i;
            if (Math.abs(sum_i-sum_i1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
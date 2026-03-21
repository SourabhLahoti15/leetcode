// Last updated: 3/21/2026, 10:12:35 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int min = nums[0];
4        for (int i=0; i<nums.length; i++) {
5            min = Math.min(min, nums[i]);
6        }
7        return min;
8    }
9}
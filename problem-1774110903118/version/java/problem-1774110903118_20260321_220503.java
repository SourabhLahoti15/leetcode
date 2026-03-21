// Last updated: 3/21/2026, 10:05:03 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length;
4        int min = nums[0];
5        for (int i=0; i<n; i++) {
6            min = Math.min(min, nums[i]);
7        }
8        return min;
9    }
10}
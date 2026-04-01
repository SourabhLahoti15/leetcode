// Last updated: 4/1/2026, 11:13:24 AM
1class Solution {
2    public int findDuplicate(int[] nums) {
3        Arrays.sort(nums);
4        for (int i=1; i<nums.length; i++) {
5            if (nums[i] == nums[i-1]) {
6                return nums[i];
7            }
8        }
9        return -1;
10    }
11}
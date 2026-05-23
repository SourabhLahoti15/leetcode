// Last updated: 5/23/2026, 11:03:55 AM
1class Solution {
2    public boolean check(int[] nums) {
3        int drop = 0;
4        for (int i=0; i<nums.length; i++){
5            if (nums[i]>nums[(i+1)%nums.length]) {
6                drop++;
7            }
8        }
9        return drop<=1;
10    }
11}
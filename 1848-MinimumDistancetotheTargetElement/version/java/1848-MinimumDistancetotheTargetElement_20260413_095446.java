// Last updated: 4/13/2026, 9:54:46 AM
1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3        int min = Integer.MAX_VALUE;
4        int n = nums.length;
5        for (int i=0; i<n; i++) {
6            if (nums[i] == target) {
7                min = Math.min(min, Math.abs(i-start));
8            }
9        }
10        return min;
11    }
12}
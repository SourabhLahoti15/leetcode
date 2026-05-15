// Last updated: 5/15/2026, 11:21:42 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int i = 0;
4        int j = nums.length-1;
5        while (i != j) {
6            int mid = (i+j)/2;
7            if (nums[mid] > nums[j]) {
8                i = mid+1;
9            } else {
10                j = mid;
11            }
12        }
13        return nums[i];
14    }
15}
// Last updated: 1/11/2026, 8:28:40 AM
1class Solution {
2    public int centeredSubarrays(int[] nums) {
3        int centered = 0;
4        for (int i=0; i<nums.length; i++) {
5            for (int j=i; j<nums.length; j++) {
6                int sum = Arrays.stream(nums, i, j+1).sum();
7                for (int k=i; k<=j; k++) {
8                    if (nums[k] == sum) {
9                        centered++;
10                        break;
11                    }
12                }
13            }
14        }
15        return centered;
16    }
17}
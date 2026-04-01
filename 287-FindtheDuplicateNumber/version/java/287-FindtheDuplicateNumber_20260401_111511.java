// Last updated: 4/1/2026, 11:15:11 AM
1class Solution {
2    public int findDuplicate(int[] nums) {
3        HashSet<Integer> set = new HashSet<>();
4        for (int i=0; i<nums.length; i++) {
5            if (set.contains(nums[i])) return nums[i];
6            else set.add(nums[i]);
7        }
8        return -1;
9    }
10}
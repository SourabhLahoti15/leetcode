// Last updated: 2/8/2026, 8:09:46 AM
1class Solution {
2    public int dominantIndices(int[] nums) {
3        int sum = 0;
4        for (int i=0; i<nums.length; i++) {
5            sum += nums[i];
6        }
7        int n = nums.length;
8        int ans = 0;
9        for (int i=0; i<nums.length-1; i++) {
10            sum -= nums[i];
11            n--;
12            if (nums[i] > (sum/n)) {
13                ans++;
14            }
15        }
16        return ans;
17    }
18}
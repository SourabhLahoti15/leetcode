// Last updated: 2/5/2026, 10:55:04 AM
1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n = nums.length;
4        int[] result = new int[n];
5        for (int i=0; i<n; i++) {
6            if (nums[i] == 0) {
7                result[i] = nums[i];
8            } else if (nums[i] > 0) {
9                result[i] = nums[(i+nums[i])%n];
10            } else if (nums[i] < 0) {
11                int idx = (i+nums[i]);
12                while (idx < 0) idx += n;
13                result[i] = nums[idx];
14            }
15        }
16        return result;
17    }
18}
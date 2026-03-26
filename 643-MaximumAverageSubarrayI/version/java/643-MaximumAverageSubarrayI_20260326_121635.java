// Last updated: 3/26/2026, 12:16:35 PM
1class Solution {
2    public double findMaxAverage(int[] nums, int k) {
3        int sum = 0;
4        for (int i=0; i<k; i++) {
5            sum += nums[i];
6        }
7        double maxavg = (double) sum/k;
8        int l = 0;
9        int r = k;
10        int n = nums.length;
11        while (r < n) {
12            sum -= nums[l];
13            sum += nums[r];
14            maxavg = Math.max(maxavg, (double) sum/k);
15            l++;
16            r++;
17        }
18        return maxavg;
19    }
20}
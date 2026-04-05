// Last updated: 4/5/2026, 9:07:35 AM
1class Solution {
2    public long minIncrease(int[] nums) {
3        int n = nums.length;
4        long[] cost = new long[n];
5        for (int i = 1; i < n - 1; i++) {
6            long need = Math.max(nums[i - 1], nums[i + 1]) + 1;
7            cost[i] = Math.max(0, need - nums[i]);
8        }
9        long[][] dp = new long[n][2];
10        long[] dpCount = new long[n];
11        long[] dpOps   = new long[n];
12        dpCount[0] = 0; dpOps[0] = 0;
13        long notCount = 0, notOps = 0;
14        long yesCount = 1, yesOps = cost[1];
15        if (yesCount > notCount || (yesCount == notCount && yesOps < notOps)) {
16            dpCount[1] = yesCount; dpOps[1] = yesOps;
17        } else {
18            dpCount[1] = notCount; dpOps[1] = notOps;
19        }
20        
21        for (int i = 2; i < n - 1; i++) {
22            long c1 = dpCount[i - 1], o1 = dpOps[i - 1];
23            long baseCount = dpCount[i - 2], baseOps = dpOps[i - 2];
24            long c2 = baseCount + 1, o2 = baseOps + cost[i];
25            if (c2 > c1 || (c2 == c1 && o2 < o1)) {
26                dpCount[i] = c2; dpOps[i] = o2;
27            } else {
28                dpCount[i] = c1; dpOps[i] = o1;
29            }
30        }
31        return dpOps[n - 2];
32    }
33}
// Last updated: 6/14/2026, 10:04:15 AM
class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        long[] cost = new long[n];
        for (int i = 1; i < n - 1; i++) {
            long need = Math.max(nums[i - 1], nums[i + 1]) + 1;
            cost[i] = Math.max(0, need - nums[i]);
        }
        long[][] dp = new long[n][2];
        long[] dpCount = new long[n];
        long[] dpOps   = new long[n];
        dpCount[0] = 0; dpOps[0] = 0;
        long notCount = 0, notOps = 0;
        long yesCount = 1, yesOps = cost[1];
        if (yesCount > notCount || (yesCount == notCount && yesOps < notOps)) {
            dpCount[1] = yesCount; dpOps[1] = yesOps;
        } else {
            dpCount[1] = notCount; dpOps[1] = notOps;
        }
        
        for (int i = 2; i < n - 1; i++) {
            long c1 = dpCount[i - 1], o1 = dpOps[i - 1];
            long baseCount = dpCount[i - 2], baseOps = dpOps[i - 2];
            long c2 = baseCount + 1, o2 = baseOps + cost[i];
            if (c2 > c1 || (c2 == c1 && o2 < o1)) {
                dpCount[i] = c2; dpOps[i] = o2;
            } else {
                dpCount[i] = c1; dpOps[i] = o1;
            }
        }
        return dpOps[n - 2];
    }
}
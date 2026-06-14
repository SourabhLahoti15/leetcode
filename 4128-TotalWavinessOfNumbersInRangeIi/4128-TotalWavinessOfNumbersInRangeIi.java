// Last updated: 6/14/2026, 10:04:18 AM
class Solution {

    static class Pair {
        long cnt;
        long sum;

        Pair(long cnt, long sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    private String s;
    private Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        s = String.valueOf(n);
        int len = s.length();

        memo = new Pair[len][2][2][11][11];

        Pair ans = dfs(0, 1, 0, 10, 10);
        return ans.sum;
    }

    private Pair dfs(int pos, int tight, int started,
                     int prev1, int prev2) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (memo[pos][tight][started][prev1][prev2] != null) {
            return memo[pos][tight][started][prev1][prev2];
        }

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        long totalCnt = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair nxt = dfs(pos + 1, ntight, 0, 10, 10);

                totalCnt += nxt.cnt;
                totalSum += nxt.sum;

            } else {

                int add = 0;

                if (started == 1 && prev2 != 10) {
                    if ((prev2 < prev1 && prev1 > d)
                            || (prev2 > prev1 && prev1 < d)) {
                        add = 1;
                    }
                }

                Pair nxt = dfs(pos + 1, ntight, 1, d, prev1);

                totalCnt += nxt.cnt;
                totalSum += nxt.sum + nxt.cnt * add;
            }
        }

        return memo[pos][tight][started][prev1][prev2]
                = new Pair(totalCnt, totalSum);
    }
}
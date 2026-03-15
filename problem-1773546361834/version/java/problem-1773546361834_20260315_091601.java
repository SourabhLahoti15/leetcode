// Last updated: 3/15/2026, 9:16:01 AM
1class Solution {
2    public long countCommas(long n) {
3        long[][] tiers = {
4                { 1_000L, 999_999L, 1 },
5                { 1_000_000L, 999_999_999L, 2 },
6                { 1_000_000_000L, 999_999_999_999L, 3 },
7                { 1_000_000_000_000L, 999_999_999_999_999L, 4 },
8                { 1_000_000_000_000_000L, Long.MAX_VALUE, 5 } 
9        };
10        long total = 0;
11        for (long[] tier : tiers) {
12            long lo = tier[0], hi = tier[1], commas = tier[2];
13            if (n < lo) break;  
14            long count = Math.min(n, hi) - lo + 1;
15            total += commas * count;
16        }
17        return total;
18    }
19}
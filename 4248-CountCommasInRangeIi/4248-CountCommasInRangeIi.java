// Last updated: 6/14/2026, 10:03:54 AM
class Solution {
    public long countCommas(long n) {
        long[][] tiers = {
                { 1_000L, 999_999L, 1 },
                { 1_000_000L, 999_999_999L, 2 },
                { 1_000_000_000L, 999_999_999_999L, 3 },
                { 1_000_000_000_000L, 999_999_999_999_999L, 4 },
                { 1_000_000_000_000_000L, Long.MAX_VALUE, 5 } 
        };
        long total = 0;
        for (long[] tier : tiers) {
            long lo = tier[0], hi = tier[1], commas = tier[2];
            if (n < lo) break;  
            long count = Math.min(n, hi) - lo + 1;
            total += commas * count;
        }
        return total;
    }
}
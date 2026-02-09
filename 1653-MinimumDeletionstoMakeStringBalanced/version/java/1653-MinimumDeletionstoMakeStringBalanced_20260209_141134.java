// Last updated: 2/9/2026, 2:11:34 PM
1class Solution {
2    public int minimumDeletions(String s) {
3        int minCost = 0;
4        int bcount = 0;
5        for (int i=0; i<s.length(); i++) {
6            if (s.charAt(i) == 'b') {
7                bcount++;
8            } else {
9                if (bcount > 0) {
10                    minCost++;
11                }
12            }
13            minCost = Math.min(minCost, bcount);
14        }
15        return minCost;
16    }
17}
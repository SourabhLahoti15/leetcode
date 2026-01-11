// Last updated: 1/11/2026, 8:18:53 AM
1class Solution {
2    public int residuePrefixes(String s) {
3        boolean[] seen = new boolean[26];
4        int distinct = 0;
5        int prefixlen = 0;
6        int count = 0;
7        for (int i=0; i<s.length(); i++) {
8            int alpha = s.charAt(i) - 'a';
9            if (!seen[alpha]) {
10                seen[alpha] = true;
11                distinct++;
12            }
13            prefixlen++;
14            if (prefixlen%3 == distinct) {
15                count++;
16            }
17        }
18        return count;
19    }
20}
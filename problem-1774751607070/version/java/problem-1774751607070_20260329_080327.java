// Last updated: 3/29/2026, 8:03:27 AM
1class Solution {
2    public int firstMatchingIndex(String s) {
3        int n = s.length();
4        int l = 0;
5        int r = n-1;
6        while (l <= r) {
7            if (s.charAt(l) == s.charAt(r)) {
8                return l;
9            }
10            l++;
11            r--;
12        }
13        return -1;
14    }
15}
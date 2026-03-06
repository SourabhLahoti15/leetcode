// Last updated: 3/6/2026, 12:00:37 PM
1class Solution {
2    public boolean checkOnesSegment(String s) {
3        boolean zeromet = false;
4        for (char ch : s.toCharArray()) {
5            if (ch == '0') {
6                zeromet = true;
7            }
8            if (ch == '1' && zeromet) {
9                return false;
10            }
11        }
12        return true;
13    }
14}
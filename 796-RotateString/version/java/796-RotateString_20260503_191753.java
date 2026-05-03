// Last updated: 5/3/2026, 7:17:53 PM
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        if (s.length() != goal.length()) return false;
4        int n = s.length();
5        StringBuilder sb = new StringBuilder(s);
6        for (int i=0; i<n; i++) {
7            char firstChar = sb.charAt(0);
8            sb.deleteCharAt(0);
9            sb.append(firstChar);
10            if (sb.toString().equals(goal)) return true;
11        }
12        return false;
13    }
14}
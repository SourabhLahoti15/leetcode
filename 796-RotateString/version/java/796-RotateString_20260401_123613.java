// Last updated: 4/1/2026, 12:36:13 PM
1class Solution {
2    public int repeatedStringMatch(String a, String b) {
3        int ans = 1;
4        String oa = a;
5        while (a.length() < b.length()) {
6            a += oa;
7            ans++;
8        }
9        if (a.contains(b)) return ans;
10        a += oa;
11        ans++;
12        if (a.contains(b)) return ans;
13        return -1;
14    }
15}
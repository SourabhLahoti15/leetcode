// Last updated: 3/5/2026, 3:18:09 PM
1class Solution {
2    public int minOperations(String s) {
3        char dig = '0';
4        int opr_0 = 0;
5        for (int i=0; i<s.length(); i++) {
6            if (s.charAt(i) != dig) {
7                opr_0++;
8            }
9            if (dig == '0') dig = '1';
10            else dig = '0';
11        }
12        dig = '1';
13        int opr_1 = 0;
14        for (int i=0; i<s.length(); i++) {
15            if (s.charAt(i) != dig) {
16                opr_1++;
17            }
18            if (dig == '1') dig = '0';
19            else dig = '1';
20        }
21        return Math.min(opr_0, opr_1);
22    }
23}
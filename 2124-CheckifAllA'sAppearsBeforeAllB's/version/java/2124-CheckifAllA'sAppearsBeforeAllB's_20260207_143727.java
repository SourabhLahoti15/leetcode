// Last updated: 2/7/2026, 2:37:27 PM
1class Solution {
2    public boolean checkString(String s) {
3        int aidx=-1;
4        int n = s.length();
5        for (int i=n-1; i>=0; i--) {
6            if (s.charAt(i) == 'a') {
7                aidx = i;
8                break;
9            }
10        }
11        for (int i=0; i<aidx; i++) {
12            if (s.charAt(i) == 'b') {
13                return false;
14            }
15        }
16        return true;
17    }
18}
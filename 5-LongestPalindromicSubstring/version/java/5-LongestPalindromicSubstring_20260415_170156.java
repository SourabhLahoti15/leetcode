// Last updated: 4/15/2026, 5:01:56 PM
1class Solution {
2    public boolean isPalindrome(String s, int i, int j) {
3        while (i < j) {
4            if (s.charAt(i) != s.charAt(j)) {
5                return false;
6            }
7            i++;
8            j--;
9        }
10        return true;
11    }
12    public String longestPalindrome(String s) {
13        int n = s.length();
14        int maxlen = 0;
15        int left = 0;
16        int right = 0;
17        for (int i=0; i<n; i++) {
18            for (int j=i; j<n; j++) {
19                if (isPalindrome(s, i, j)) {
20                    int len = j-i+1;
21                    if (len > maxlen) {
22                        maxlen = len;
23                        left = i;
24                        right = j;
25                    }
26                }
27            }
28        }
29        return s.substring(left, right+1);
30    }
31}
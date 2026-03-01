// Last updated: 3/1/2026, 8:19:17 AM
1class Solution {
2    public boolean isVowel(char ch) {
3        if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
4            return true;
5        }
6        return false;
7    }
8    public String trimTrailingVowels(String s) {
9        int n = s.length();
10        int idx = n-1;
11        while (idx >= 0 && isVowel(s.charAt(idx))) {
12            idx--;
13        }
14        return s.substring(0, idx+1);
15    }
16}
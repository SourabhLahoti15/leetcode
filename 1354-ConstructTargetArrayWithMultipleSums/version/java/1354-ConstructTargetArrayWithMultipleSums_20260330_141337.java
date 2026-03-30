// Last updated: 3/30/2026, 2:13:37 PM
1class Solution {
2    public boolean detectCapitalUse(String word) {
3        int upperCount = 0;
4
5        for (char ch : word.toCharArray()) {
6            if (Character.isUpperCase(ch)) {
7                upperCount++;
8            }
9        }
10
11        if (upperCount == word.length()) return true;
12        if (upperCount == 0) return true;
13        if (upperCount == 1 && Character.isUpperCase(word.charAt(0))) return true;
14
15        return false;
16    }
17}
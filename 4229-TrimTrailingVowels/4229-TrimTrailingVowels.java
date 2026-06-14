// Last updated: 6/14/2026, 10:03:57 AM
class Solution {
    public boolean isVowel(char ch) {
        if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            return true;
        }
        return false;
    }
    public String trimTrailingVowels(String s) {
        int n = s.length();
        int idx = n-1;
        while (idx >= 0 && isVowel(s.charAt(idx))) {
            idx--;
        }
        return s.substring(0, idx+1);
    }
}
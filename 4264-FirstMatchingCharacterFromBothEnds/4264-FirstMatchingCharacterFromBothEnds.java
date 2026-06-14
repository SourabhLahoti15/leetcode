// Last updated: 6/14/2026, 10:03:50 AM
class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                return l;
            }
            l++;
            r--;
        }
        return -1;
    }
}
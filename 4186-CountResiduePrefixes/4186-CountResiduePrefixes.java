// Last updated: 6/14/2026, 10:04:09 AM
class Solution {
    public int residuePrefixes(String s) {
        boolean[] seen = new boolean[26];
        int distinct = 0;
        int prefixlen = 0;
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            int alpha = s.charAt(i) - 'a';
            if (!seen[alpha]) {
                seen[alpha] = true;
                distinct++;
            }
            prefixlen++;
            if (prefixlen%3 == distinct) {
                count++;
            }
        }
        return count;
    }
}
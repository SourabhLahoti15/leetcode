class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        int maxsum = 0;
        int prevrun = -1;
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                ones++;
                i++;
            } else {
                int cur = 0;
                while (i < n && s.charAt(i) == '0') {
                    cur++;
                    i++;
                }
                if (prevrun > 0) {
                    maxsum = Math.max(maxsum, prevrun + cur);
                }
                prevrun = cur;
            }
        }
        return ones + maxsum;
    }
}
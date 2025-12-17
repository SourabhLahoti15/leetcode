// Last updated: 12/17/2025, 10:50:40 AM
class Solution {
    public int minimumFlips(int n) {
        String revs = "";
        while (n > 0) {
            int rem = n%2;
            revs += String.valueOf(rem);
            n = n/2;
        }
        StringBuilder sb = new StringBuilder(revs);
        sb.reverse();
        String s = sb.toString();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != revs.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }
}
// Last updated: 12/17/2025, 10:50:44 AM
class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }
        String s = String.valueOf(n);
        String nz = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                nz += s.charAt(i);
            }
        }
        long x = Integer.parseInt(nz);
        long originalx = x;
        long sum = 0;
        while (x>0) {
            long ld = x%10;
            sum += ld;
            x = x/10;
        }
        return originalx*sum;
    }
}
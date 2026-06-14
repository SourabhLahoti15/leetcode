// Last updated: 6/14/2026, 10:03:38 AM
class Solution {
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        int r = 0;
        int tempn = n;
        while (tempn > 0) {
            int ld = tempn % 10;
            r = r*10 + ld;
            tempn = tempn / 10;
        }
        int start = Math.min(n, r);
        int end = Math.max(n, r);
        int sum = 0;
        for (int i=start; i<=end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
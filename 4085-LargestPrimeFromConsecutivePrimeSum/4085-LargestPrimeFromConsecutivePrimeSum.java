// Last updated: 12/17/2025, 10:50:46 AM
class Solution {
    private boolean isPrime(int x) {
    if (x < 2) return false;
    if (x % 2 == 0) return x == 2;
    for (int i = 3; i * i <= x; i += 2) {
        if (x % i == 0) return false;
    }
    return true;
    }
    public int largestPrime(int n) {
        int sum = 0;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
                if (sum > n) break;
                if (isPrime(sum)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
// Last updated: 12/17/2025, 10:52:01 AM
class Solution {
    public int recursion(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }
        int mid = (int)Math.pow(2, n-1)/2;
        if (k <= mid) {
            return recursion(n-1, k);
        } else {
            return 1 - recursion(n-1, k-mid);
        }
    }
    public int kthGrammar(int n, int k) {
        return recursion(n, k);
    }
}
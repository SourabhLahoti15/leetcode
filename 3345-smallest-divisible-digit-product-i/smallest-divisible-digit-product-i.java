class Solution {
    public int productOfDigits(int n) {
        int product = 1;
        while (n > 0) {
            int ld = n % 10;
            product *= ld;
            n = n / 10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        while (true) {
            if (productOfDigits(n) % t == 0) {
                return n;
            }
            n++;
        }
    }
}
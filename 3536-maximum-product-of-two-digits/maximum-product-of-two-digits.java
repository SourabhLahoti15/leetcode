class Solution {
    public int maxProduct(int n) {
        int first=0, second=0;
        while (n > 0) {
            int ld = n % 10;
            if (ld > first) {
                second = first;
                first = ld;
            } else if (ld > second) {
                second = ld;
            }
            n = n / 10;
        }
        return first*second;
    }
}
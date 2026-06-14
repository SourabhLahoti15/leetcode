// Last updated: 6/14/2026, 10:03:55 AM
class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        return n - 1000 + 1;
    }
}
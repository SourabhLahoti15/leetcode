// Last updated: 12/17/2025, 10:51:26 AM
class Solution {
    public int countOdds(int low, int high) {
        int ans = high - low;
        ans /= 2;
        if (low%2!=0 || high%2!=0) {
            ans++;
        }
        return ans;
    }
}
// Last updated: 6/14/2026, 10:04:10 AM
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = nums[0];
        boolean ok = true;
        for (int i=0; i<n; i++) {
            if (nums[i] != (start+i)%n) {
                ok = false;
                break;
            }
        }
        if (ok) {
            int op1 = (n - start) % n;

            int op2 = 2 + start % n;

            ans = Math.min(ans, Math.min(op1, op2));
        }
        start = nums[0];
        ok = true;
        for (int i=0; i<n; i++) {
            if (nums[i] != ((start - i) % n + n) % n) {
                ok = false;
                break;
            }
        }
        if (ok) {
            // rotate then reverse
            int op1 = 1 + (start + 1) % n;

            // reverse then rotate
            int op2 = 1 + (n - ((start + 1) % n)) % n;

            ans = Math.min(ans, Math.min(op1, op2));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
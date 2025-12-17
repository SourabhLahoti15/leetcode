// Last updated: 12/17/2025, 10:51:29 AM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int x = 0;
        int y = n;
        int i = 0;
        while (x<n && y<2*n) {
            ans[i] = nums[x];
            x++;
            ans[i+1] = nums[y];
            y++;
            i += 2;
        }
        return ans;
    }
}
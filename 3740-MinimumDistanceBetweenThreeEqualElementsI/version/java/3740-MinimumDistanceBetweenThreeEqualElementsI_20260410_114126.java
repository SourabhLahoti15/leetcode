// Last updated: 4/10/2026, 11:41:26 AM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length;
4        int ans = Integer.MAX_VALUE;
5        for (int i=0; i<n; i++) {
6            for (int j=i+1; j<n; j++) {
7                for (int k=j+1; k<n; k++) {
8                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
9                        ans = Math.min(ans, Math.abs(i-j) + Math.abs(j-k) + Math.abs(k-i));
10                    }
11                }
12            }
13        }
14        return (ans == Integer.MAX_VALUE) ? -1 : ans;
15    }
16}
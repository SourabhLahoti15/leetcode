// Last updated: 4/15/2026, 4:25:11 PM
1class Solution {
2    public int trap(int[] height) {
3        int n = height.length;
4        int[] leftMax = new int[n];
5        int[] rightMax = new int[n];
6        // leftMax
7        leftMax[0] = height[0];
8        for (int i=1; i<n; i++) {
9            leftMax[i] = Math.max(leftMax[i-1], height[i]);
10        }
11        // rightMax
12        rightMax[n-1] = height[n-1];
13        for (int i=n-2; i>=0; i--) {
14            rightMax[i] = Math.max(rightMax[i+1], height[i]);
15        }
16        // calculate water
17        int water = 0;
18        for (int i=0; i<n; i++) {
19            water += Math.min(leftMax[i], rightMax[i]) - height[i];
20        }
21        return water;
22    }
23}
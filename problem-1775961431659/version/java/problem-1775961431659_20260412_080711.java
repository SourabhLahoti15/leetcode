// Last updated: 4/12/2026, 8:07:11 AM
1class Solution {
2    public int[] findDegrees(int[][] matrix) {
3        int n = matrix.length;
4        int[] ans = new int[n];
5        for (int u=0; u<n; u++) {
6            for (int v=0; v<n; v++) {
7                if (matrix[u][v] == 1) {
8                    ans[u]++;
9                    // ans[v]++;
10                }
11            }
12        }
13        return ans;
14    }
15}
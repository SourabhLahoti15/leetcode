// Last updated: 6/14/2026, 10:03:44 AM
class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        for (int u=0; u<n; u++) {
            for (int v=0; v<n; v++) {
                if (matrix[u][v] == 1) {
                    ans[u]++;
                    // ans[v]++;
                }
            }
        }
        return ans;
    }
}
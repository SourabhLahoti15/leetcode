// Last updated: 5/6/2026, 2:44:37 PM
1class Solution {
2    public int[][] transpose(int[][] matrix) {
3        int n=matrix.length;
4        int m=matrix[0].length;
5        int [][]ans=new int[m][n];
6        for(int i=0;i<n;i++){
7            for(int j=0;j<m;j++){
8                ans[j][i]=matrix[i][j];
9            }
10        }
11
12        return ans;
13    }
14}
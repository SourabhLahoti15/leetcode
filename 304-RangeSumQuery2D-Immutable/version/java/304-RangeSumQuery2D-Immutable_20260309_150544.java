// Last updated: 3/9/2026, 3:05:44 PM
1class NumMatrix {
2    int[][] matrix;
3    int[][] prefix;
4    int n;
5    int m;
6    public NumMatrix(int[][] matrix) {
7        this.matrix = matrix;
8        this.n = matrix.length;
9        this.m = matrix[0].length;
10        prefix = new int[n][m];
11        for (int i=0; i<n; i++) {
12            for (int j=0; j<m; j++) {
13                int top = i!=0 ? prefix[i-1][j] : 0;
14                int left = j!=0 ? prefix[i][j-1] : 0;
15                int topleft = i!=0 && j!=0 ? prefix[i-1][j-1] : 0;
16                prefix[i][j] = top + left - topleft + matrix[i][j];
17            }
18        }
19    }
20    
21    public int sumRegion(int row1, int col1, int row2, int col2) {
22        if (row1 == 0 && col1 == 0) {
23            return prefix[row2][col2];
24        }
25        if (row1 == 0) {
26            return prefix[row2][col2] - prefix[row2][col1-1];
27        }
28        if (col1 == 0) {
29            return prefix[row2][col2] - prefix[row1-1][col2];
30        }
31        return prefix[row2][col2] - prefix[row1-1][col2] - prefix[row2][col1-1] + prefix[row1-1][col1-1];
32    }
33}
34
35/**
36 * Your NumMatrix object will be instantiated and called as such:
37 * NumMatrix obj = new NumMatrix(matrix);
38 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
39 */ 
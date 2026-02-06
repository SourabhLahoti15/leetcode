// Last updated: 2/6/2026, 11:24:47 AM
1class Solution {
2    int m;
3    int n;
4    public void dfs(int[][] grid, int i, int j) {
5        if (i<0 || i>=m || j<0 || j>=n) {
6            return;
7        }
8        if (grid[i][j] != 1) {
9            return;
10        }
11        grid[i][j] = 0;
12        dfs(grid, i-1, j);
13        dfs(grid, i+1, j);
14        dfs(grid, i, j-1);
15        dfs(grid, i, j+1);
16    }
17    public int numEnclaves(int[][] grid) {
18        m = grid.length;
19        n = grid[0].length;
20        for (int i=0; i<m; i++) {
21            dfs(grid, i, 0);
22            dfs(grid, i, n-1);
23        } 
24        for (int j=0; j<n; j++) {
25            dfs(grid, 0, j);
26            dfs(grid, m-1, j);
27        }
28        int count = 0;
29        for (int i=0; i<m; i++) {
30            for (int j=0; j<n; j++) {
31                if (grid[i][j] == 1) {
32                    count++;
33                }
34            }
35        }
36        return count;
37    }
38}
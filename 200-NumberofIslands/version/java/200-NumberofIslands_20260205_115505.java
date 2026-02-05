// Last updated: 2/5/2026, 11:55:05 AM
1class Solution {
2    static int n;
3    static int m;
4    public void dfs(char[][] grid, int i, int j) {
5        if (i<0 || i>=n || j<0 || j>=m) return;
6        if (grid[i][j] == '0') return;
7
8        grid[i][j] = '0';
9        
10        dfs(grid, i + 1, j);
11        dfs(grid, i - 1, j);
12        dfs(grid, i, j + 1);
13        dfs(grid, i, j - 1);
14    }
15    public int numIslands(char[][] grid) {
16        n = grid.length;
17        m = grid[0].length;
18        int count=0;
19        for (int i=0; i<n; i++) {
20            for (int j=0; j<m; j++) {
21                if (grid[i][j] == '1') {
22                    count++;
23                    dfs(grid, i, j);
24                }
25            }
26        }
27        return count;
28    }
29}
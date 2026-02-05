// Last updated: 2/5/2026, 2:48:24 PM
1class Solution {
2    static int n;
3    static int m;
4    static boolean[][] visited;
5    public int dfs(int[][] grid, int i, int j) {
6        if (i<0 || i>=n || j<0 || j>=m) {
7            return 1;
8        }
9        if (visited[i][j]) {
10            return 0;
11        }
12        if (grid[i][j] == 0) {
13            return 1;
14        }
15        visited[i][j] = true;
16        return dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
17    }
18    public int islandPerimeter(int[][] grid) {
19        n = grid.length;
20        m = grid[0].length;
21        visited = new boolean[n][m];
22        int ans = 0;
23        for (int i=0; i<n; i++) {
24            for (int j=0; j<m; j++) {
25                if (grid[i][j] == 1) {
26                    return ans = dfs(grid, i, j);                    
27                }
28            }
29        }
30        return ans;
31    }
32}
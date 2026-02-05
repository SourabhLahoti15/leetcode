// Last updated: 2/5/2026, 11:41:46 AM
1class Solution {
2    static int n;
3    static int m;
4    static boolean[][] visited;
5    public int dfs(int[][] grid, int i, int j) {
6        if (i<0 || i>=n || j<0 || j>=m) return 0;
7        if (visited[i][j]) return 0;
8        visited[i][j] = true;
9        if (grid[i][j] == 1) { 
10            return 1 + (
11                (dfs(grid, i+1, j) + dfs(grid, i-1, j)) +
12                (dfs(grid, i, j+1) + dfs(grid, i, j-1))
13                );
14        } else {
15            return 0;
16        }
17    }
18    public int maxAreaOfIsland(int[][] grid) {
19        n = grid.length;
20        m = grid[0].length;
21        int max = 0;
22        for (int i=0; i<n; i++) {
23            for (int j=0; j<m; j++) {
24                visited = new boolean[n][m];
25                max = Math.max(dfs(grid, i, j), max);
26            }
27        }
28        return max;
29    }
30}
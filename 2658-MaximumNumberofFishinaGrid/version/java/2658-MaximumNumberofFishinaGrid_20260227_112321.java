// Last updated: 2/27/2026, 11:23:21 AM
1class Solution {
2    boolean[][] visited;
3    int[] dx = {-1, 1, 0, 0};
4    int[] dy = {0, 0, -1, 1};
5    public int bfs(int[][] grid, int i, int j) {
6        int fish = 0;
7        Queue<int[]> q = new LinkedList<>();
8        q.offer(new int[]{i, j});
9        while (!q.isEmpty()) {
10            int[] cur = q.poll();
11            int x = cur[0];
12            int y = cur[1];
13            fish += grid[x][y];
14            for (int nei=0; nei<4; nei++) {
15                int nx = x + dx[nei];
16                int ny = y + dy[nei];
17                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
18                    if (!visited[nx][ny] && grid[nx][ny] > 0) {
19                        visited[nx][ny] = true;
20                        q.offer(new int[]{nx, ny});
21                    }
22                }
23            }
24        }
25        return fish;
26    }
27    static int m;
28    static int n;
29    public int findMaxFish(int[][] grid) {
30        m = grid.length;
31        n = grid[0].length;
32        int max_fish = 0;
33        visited = new boolean[m][n];
34        for (int i=0; i<m; i++) {
35            for (int j=0; j<n; j++) {
36                if (!visited[i][j] && grid[i][j] > 0) {
37                    visited[i][j] = true;
38                    max_fish = Math.max(max_fish, bfs(grid, i, j));
39                }
40            }
41        }
42        return max_fish;
43    }
44}
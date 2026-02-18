// Last updated: 2/18/2026, 10:06:23 AM
1class Solution {
2    public int shortestPathBinaryMatrix(int[][] grid) {
3        int[] dx = { -1, 1, 0, 0, 1, -1, 1, -1 };
4        int[] dy = { 0, 0, -1, 1, 1, -1, -1, 1 };
5        int n = grid.length;
6        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
7            return -1;
8        }
9        Queue<int[]> q = new LinkedList<>();
10        q.offer(new int[] { 0, 0 });
11        int len = 1;
12        while (!q.isEmpty()) {
13            int qsize = q.size();
14            for (int lev = 0; lev < qsize; lev++) {
15                int[] cur = q.poll();
16                int x = cur[0];
17                int y = cur[1];
18                if (x == n - 1 && y == n - 1) {
19                    return len;
20                }
21                for (int i = 0; i < 8; i++) {
22                    int nx = x + dx[i];
23                    int ny = y + dy[i];
24                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
25                        q.offer(new int[] { nx, ny });
26                        grid[nx][ny] = 1;
27                    }
28                }
29            }
30            len++;
31        }
32        return -1;
33    }
34}
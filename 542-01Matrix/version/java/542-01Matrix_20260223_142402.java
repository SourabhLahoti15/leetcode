// Last updated: 2/23/2026, 2:24:02 PM
1class Solution {
2    public int[][] updateMatrix(int[][] mat) {
3        int n = mat.length;
4        int m = mat[0].length;
5        Queue<int[]> q = new LinkedList<>();
6        int[][] dis = new int[n][m];
7        for (int i=0; i<n; i++) {
8            for (int j=0; j<m; j++) {
9                if (mat[i][j] == 0) {
10                    dis[i][j] = 0;
11                    q.offer(new int[]{i, j});
12                } else {
13                    dis[i][j] = Integer.MAX_VALUE;
14                }
15            }
16        }
17        int[] dx = {-1, 1, 0, 0};
18        int[] dy = {0, 0, -1, 1};
19        while (!q.isEmpty()) {
20            int[] cur = q.poll();
21            int i = cur[0];
22            int j = cur[1];
23            for (int nei=0; nei<4; nei++) {
24                int ni = i + dx[nei];
25                int nj = j + dy[nei];
26                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
27                    if (dis[ni][nj] > dis[i][j] + 1) {
28                        dis[ni][nj] = dis[i][j] + 1;
29                        q.offer(new int[]{ni, nj});
30                    }
31                }
32            }
33        }
34        return dis;
35    }
36}
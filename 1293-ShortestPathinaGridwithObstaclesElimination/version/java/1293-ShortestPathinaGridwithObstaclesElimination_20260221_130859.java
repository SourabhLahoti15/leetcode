// Last updated: 2/21/2026, 1:08:59 PM
1class Solution {
2    public int shortestPath(int[][] grid, int k) {
3        int[] dx = { -1, 1, 0, 0 };
4        int[] dy = { 0, 0, -1, 1 };
5        int m = grid.length;
6        int n = grid[0].length;
7        PriorityQueue<int[]> pq = new PriorityQueue<>(
8            (a, b) -> Integer.compare(a[3], b[3])
9        );
10        int steps = 0;
11        pq.offer(new int[] { 0, 0, k, steps });
12        int[][] visited = new int[m][n];
13        for (int i=0; i<m; i++) {
14            Arrays.fill(visited[i], -1);
15        }
16        while (!pq.isEmpty()) {
17            int[] cur = pq.poll();
18            int i = cur[0];
19            int j = cur[1];
20            int uk = cur[2];
21            int usteps = cur[3];
22            if (uk < 0) {
23                continue;
24            }
25            if (visited[i][j] >= uk) {
26                continue;
27            }
28            visited[i][j] = uk;
29            if (i == m-1 && j == n-1) {
30                return usteps;
31            }
32            for (int nei = 0; nei < 4; nei++) {
33                int ni = i + dx[nei];
34                int nj = j + dy[nei];
35                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
36                    pq.offer(new int[] { ni, nj, uk - grid[ni][nj], usteps+1 });
37                }
38            }
39        }
40        return -1;
41    }
42}
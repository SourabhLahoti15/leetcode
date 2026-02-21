// Last updated: 2/21/2026, 12:20:47 PM
1class Solution {
2    public int minimumObstacles(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int[] dx = { -1, 1, 0, 0 };
6        int[] dy = { 0, 0, -1, 1 };
7        int count = grid[0][0] == 0 ? 0 : 1;
8        PriorityQueue<int[]> pq = new PriorityQueue<>(
9                (a, b) -> Integer.compare(a[2], b[2]));
10        pq.offer(new int[] { 0, 0, count });
11        int[][] dist = new int[m][n];
12        for (int i = 0; i < m; i++) {
13            Arrays.fill(dist[i], Integer.MAX_VALUE);
14        }
15        dist[0][0] = count;
16        while (!pq.isEmpty()) {
17            int[] cur = pq.poll();
18            int i = cur[0];
19            int j = cur[1];
20            count = cur[2];
21            if (count > dist[i][j]) {
22                continue;
23            }
24            if (i == m - 1 && j == n - 1) {
25                return count;
26            }
27            for (int nei = 0; nei < 4; nei++) {
28                int ni = i + dx[nei];
29                int nj = j + dy[nei];
30                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
31                    if (count + grid[ni][nj] < dist[ni][nj]) {
32                        dist[ni][nj] = count + grid[ni][nj];
33                        pq.offer(new int[] { ni, nj, count + grid[ni][nj] });
34                    }
35                }
36            }
37        }
38        return -1;
39    }
40}
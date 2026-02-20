// Last updated: 2/20/2026, 12:27:42 PM
1class Solution {
2    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
3        int m = grid.size();
4        int n = grid.get(0).size();
5        int[] dx = {-1, 1, 0, 0};
6        int[] dy = {0, 0, -1, 1};
7        boolean[][] visited = new boolean[m][n];
8        PriorityQueue<int[]> pq = new PriorityQueue<>(
9            (a, b) -> Integer.compare(b[2], a[2])
10        );
11        pq.offer(new int[] { 0, 0, health-grid.get(0).get(0) });
12        visited[0][0] = true;
13        while (!pq.isEmpty()) {
14            int[] cur = pq.poll();
15            int i = cur[0];
16            int j = cur[1];
17            int h = cur[2];
18            if (i == m-1 && j == n-1 && h>0) {
19                return true;
20            }
21            for (int nei=0; nei<4; nei++) {
22                int ni = i+dx[nei];
23                int nj = j+dy[nei];
24                if (ni>=0 && ni<m && nj>=0 && nj<n && !visited[ni][nj]) {
25                    visited[ni][nj] = true;
26                    pq.offer(new int[]{ ni, nj, h-grid.get(ni).get(nj) });
27                }
28            }
29        }
30        return false;
31    }
32}
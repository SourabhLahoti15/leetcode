// Last updated: 2/23/2026, 3:03:59 PM
1class Solution {
2    public int minimumEffortPath(int[][] heights) {
3        int n = heights.length;
4        int m = heights[0].length;
5        if (n==1 && m==1) return 0;
6        PriorityQueue<int[]> pq = new PriorityQueue<>(
7                (a, b) -> Integer.compare(a[2], b[2]));
8        int[][] effort = new int[n][m];
9        for (int i = 0; i < n; i++) {
10            Arrays.fill(effort[i], Integer.MAX_VALUE);
11        }
12        pq.offer(new int[] { 0, 0, 0 });
13        int[] dx = { -1, 1, 0, 0 };
14        int[] dy = { 0, 0, -1, 1 };
15        while (!pq.isEmpty()) {
16            int[] cur = pq.poll();
17            int i = cur[0];
18            int j = cur[1];
19            int ueffort = cur[2];
20            if (ueffort > effort[i][j]) {
21                continue;
22            }
23            for (int nei = 0; nei < 4; nei++) {
24                int ni = i + dx[nei];
25                int nj = j + dy[nei];
26                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
27                    int veffort = Math.max(ueffort, Math.abs(heights[i][j] - heights[ni][nj]));
28                    if (veffort < effort[ni][nj]) {
29                        effort[ni][nj] = veffort;
30                        pq.offer(new int[] { ni, nj, veffort });
31                    }
32                }
33            }
34        }
35        return effort[n - 1][m - 1];
36    }
37}
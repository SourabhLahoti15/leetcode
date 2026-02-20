// Last updated: 2/20/2026, 11:56:52 AM
1class Solution {
2    public int swimInWater(int[][] grid) {
3        int[] dx = { -1, 1, 0, 0 };
4        int[] dy = { 0, 0, -1, 1 };
5        int n = grid.length;
6        PriorityQueue<int[]> pq = new PriorityQueue<>(
7                (a, b) -> a[2] - b[2]);
8        int[][] distance = new int[n][n];
9        for (int i=0; i<n; i++) {
10            Arrays.fill(distance[i], Integer.MAX_VALUE);
11        }
12        distance[0][0] = 0;
13        pq.offer(new int[] { 0, 0, grid[0][0] });
14        while (!pq.isEmpty()) {
15            int[] cur = pq.poll();
16            int i = cur[0];
17            int j = cur[1];
18            int time = cur[2];
19           
20            if (i==n-1 && j==n-1) {
21                return time;
22            }
23            for (int nei = 0; nei < 4; nei++) {
24                int ni = i + dx[nei];
25                int nj = j + dy[nei];
26                if (ni>=0 && ni<n && nj>=0 && nj<n) {
27
28                int newtime=Math.max(time,grid[ni][nj]);
29                if (newtime<distance[ni][nj]){
30                    distance[ni][nj] = newtime;
31                    pq.offer(new int[] { ni, nj, newtime});
32                }
33                }
34            }
35        }
36        return -1;
37    }
38}
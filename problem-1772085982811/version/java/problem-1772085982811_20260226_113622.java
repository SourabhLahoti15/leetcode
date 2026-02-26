// Last updated: 2/26/2026, 11:36:22 AM
1class Solution {
2    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
3        int[] dx = {-1, 1, 0, 0};
4        int[] dy = {0, 0, -1, 1};
5        int m = image.length;
6        int n = image[0].length;
7        int ogcolor = image[sr][sc];
8        if (ogcolor == color) return image;
9        Queue<int[]> q = new LinkedList<>();
10        q.offer(new int[]{sr, sc});
11        image[sr][sc] = color;
12        while (!q.isEmpty()) {
13            int[] cur = q.poll();
14            int i = cur[0];
15            int j = cur[1];
16            for (int nei=0; nei<4; nei++) {
17                int ni = i + dx[nei];
18                int nj = j + dy[nei];
19                if (ni >= 0 && ni < m && nj >= 0 && nj < n && image[ni][nj] == ogcolor) {
20                    q.offer(new int[]{ni, nj});
21                    image[ni][nj] = color;
22                }
23            }
24        }
25        return image;
26    }
27}
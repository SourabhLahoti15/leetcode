class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[2], a[2])
        );
        pq.offer(new int[] { 0, 0, health-grid.get(0).get(0) });
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int h = cur[2];
            if (i == m-1 && j == n-1 && h>0) {
                return true;
            }
            for (int nei=0; nei<4; nei++) {
                int ni = i+dx[nei];
                int nj = j+dy[nei];
                if (ni>=0 && ni<m && nj>=0 && nj<n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.offer(new int[]{ ni, nj, h-grid.get(ni).get(nj) });
                }
            }
        }
        return false;
    }
}
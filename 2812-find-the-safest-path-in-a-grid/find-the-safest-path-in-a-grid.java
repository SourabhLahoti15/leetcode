class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int n;
    int[][] arr;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        Queue<int[]> q = new LinkedList<>();
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = grid.get(i).get(j);
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{ i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int i=0; i<4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] > 0) continue;
                arr[nr][nc] = arr[r][c] + 1;
                q.offer(new int[]{ nr, nc });
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{ arr[0][0], 0, 0 });
        arr[0][0] = -1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int sfac = cur[0], r = cur[1], c = cur[2];
            if (r == n-1 && c == n-1) return sfac-1;
            for (int i=0; i<4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] < 0) continue;
                int min = Math.min(sfac, arr[nr][nc]);
                pq.offer(new int[]{ min, nr, nc });
                arr[nr][nc] = -1;
            }
        }
        return 0;
    }
}
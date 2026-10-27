class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public long sum(int i, int j) {
        if (grid[i][j] <= 0) return 0;
        long ans = grid[i][j];
        grid[i][j] = 0;
        for (int d=0; d<4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                ans += sum(nx, ny);
            }
        }
        return ans;
    }
    int[][] grid;
    int m;
    int n;
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    if (sum(i, j) % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
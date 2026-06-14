// Last updated: 6/14/2026, 10:04:46 AM
class Solution {
    public int countLocalMaximums(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<int[]>[] pos = new ArrayList[201];

        for (int i = 0; i <= 200; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pos[matrix[i][j]].add(new int[]{i, j});
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int x = matrix[i][j];

                if (x == 0) continue;

                boolean ok = true;

                for (int bigger = x + 1; bigger <= 200 && ok; bigger++) {

                    for (int[] p : pos[bigger]) {

                        int r = p[0];
                        int c = p[1];

                        int rowDist = Math.abs(r - i);
                        int colDist = Math.abs(c - j);

                        if (rowDist <= x && colDist <= x) {

                            // ignore corners
                            if (rowDist == x && colDist == x) {
                                continue;
                            }

                            ok = false;
                            break;
                        }
                    }
                }

                if (ok) ans++;
            }
        }

        return ans;
    }
}
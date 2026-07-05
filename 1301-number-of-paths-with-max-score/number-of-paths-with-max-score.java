class Solution {
    int n;
    int MOD = 1_000_000_007;
    List<String> board;

    int[][] score;
    int[][] ways;
    boolean[][] vis;

    int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        n = board.size();

        score = new int[n][n];
        ways = new int[n][n];
        vis = new boolean[n][n];

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X')
                    continue;
                if (i == n - 1 && j == n - 1)
                    continue;
                int bestScore = -1;
                int totalWays = 0;
                
                for (int[] d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni >= n || nj >= n) continue;
                    if (score[ni][nj] == -1) continue;
                    if (score[ni][nj] > bestScore) {
                        bestScore = score[ni][nj];
                        totalWays = ways[ni][nj];
                    } else if (score[ni][nj] == bestScore) {
                        totalWays = (totalWays + ways[ni][nj]) % MOD;
                    }
                }
                if (bestScore == -1) continue;
                char ch = board.get(i).charAt(j);
                if (Character.isDigit(ch))
                    bestScore += ch - '0';
                score[i][j] = bestScore;
                ways[i][j] = totalWays;
            }
        }
        if (ways[0][0] == 0) {
            return new int[]{0, 0};
        }
        return new int[]{score[0][0], ways[0][0]};
    }
}
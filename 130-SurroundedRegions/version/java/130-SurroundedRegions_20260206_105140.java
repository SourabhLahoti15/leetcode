// Last updated: 2/6/2026, 10:51:40 AM
1class Solution {
2    int n;
3    int m;
4    public void dfs(char[][] board, int i, int j) {
5        if (i<0 || i>=n || j<0 || j>=m) {
6            return;
7        }
8        if (board[i][j] != 'O') {
9            return;
10        }
11        board[i][j] = '#';
12        dfs(board, i-1, j);
13        dfs(board, i+1, j);
14        dfs(board, i, j-1);
15        dfs(board, i, j+1);
16    }
17    public void solve(char[][] board) {
18        n = board.length;
19        m = board[0].length;
20        for (int i = 0; i < n; i++) {
21            dfs(board, i, 0);
22            dfs(board, i, m - 1);
23        }
24        for (int j = 0; j < m; j++) {
25            dfs(board, 0, j);
26            dfs(board, n - 1, j);
27        }
28        for (int i = 0; i < n; i++) {
29            for (int j = 0; j < m; j++) {
30                if (board[i][j] == 'O') board[i][j] = 'X';
31                else if (board[i][j] == '#') board[i][j] = 'O';
32            }
33        }
34    }
35}
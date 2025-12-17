// Last updated: 12/17/2025, 10:54:21 AM
class Solution {
    public boolean func(char[][] board) {
        for (int row=0; row<9; row++) {
            for (int clm=0; clm<9; clm++) {
                if (board[row][clm] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isSafe(board, row, clm, ch)) {
                            board[row][clm] = ch;
                            if (func(board)) {
                                return true;
                            }
                            board[row][clm] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board, int row, int clm, char c) {
        for (int i=0; i<9; i++) {
            if (board[row][i] == c) {
                return false;
            }
            if (board[i][clm] == c) {
                return false;
            }
            int boxrow = 3 * (row / 3) + i / 3;
            int boxclm = 3 * (clm / 3) + i % 3;
            if (board[boxrow][boxclm] == c) {
                return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        func(board);
    }
}
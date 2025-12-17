// Last updated: 12/17/2025, 10:54:00 AM
class Solution {
    public boolean search(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = search(board, i+1, j, word, idx+1) || search(board, i, j+1, word, idx+1) || search(board, i-1, j, word, idx+1) || search(board, i, j-1, word, idx+1);
        board[i][j] = temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (search(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
class Solution {
    private int ROWS, COLS;
    private char VISITED;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        VISITED = '.';

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (dfs(board, word, row, col, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) return true;
        if (row < 0 || col < 0 || row >= ROWS || col >= COLS 
        || board[row][col] != word.charAt(index) || board[row][col] == VISITED) return false;

        board[row][col] = VISITED;

        int nextIndex = index + 1;
        if (dfs(board, word, row + 1, col, nextIndex) ||
        dfs(board, word, row - 1, col, nextIndex) ||
        dfs(board, word, row, col + 1, nextIndex) ||
        dfs(board, word, row, col - 1, nextIndex)) return true;

        board[row][col] = word.charAt(index);
        return false;
    }
}

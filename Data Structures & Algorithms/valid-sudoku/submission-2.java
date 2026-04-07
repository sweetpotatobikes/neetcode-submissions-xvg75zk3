class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char curr = board[row][col];
                if (curr != '.') {
                    if (!seen.add(curr + " row " + row) ||
                        !seen.add(curr + " col " + col) ||
                        !seen.add(curr + " block " + row/3 + col/3)) {
                        return false;
                    } 
                }
            }
        }
        return true;
    }
}

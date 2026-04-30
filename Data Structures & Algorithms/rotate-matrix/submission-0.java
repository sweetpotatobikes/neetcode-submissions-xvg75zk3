class Solution {
    public void rotate(int[][] matrix) {
        this.flip(matrix);
        this.transpose(matrix);
    }

    private void flip(int[][] matrix) {
        final int N = matrix.length;
        for (int top = 0; top < N/2; top++) {
            int bottom = N - 1 - top;
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
        }
    }

    private void transpose(int[][] matrix) {
        final int N = matrix.length;
        for (int row = 0; row < N; row++) {
            for (int col = row + 1; col < N; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}

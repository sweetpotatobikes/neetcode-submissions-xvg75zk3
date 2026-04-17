class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) q.offer(new int[] { i,j });
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] direction : directions) {
                int r = row + direction[0], c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[r][c] = grid[row][col] + 1;
                q.offer(new int[] {r,c});
            }
        }
    }
}

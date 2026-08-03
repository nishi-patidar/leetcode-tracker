// Last updated: 8/3/2026, 12:47:41 PM
class Solution {
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj, char c) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + dirX[k];
            int nj = j + dirY[k];

            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == c) {
                if (visited[ni][nj]) {
                    if (ni != pi || nj != pj) {
                        return true;
                    }
                } else {
                    if (dfs(grid, visited, ni, nj, i, j, c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

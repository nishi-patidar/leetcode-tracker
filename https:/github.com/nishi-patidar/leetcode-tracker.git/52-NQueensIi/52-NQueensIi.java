// Last updated: 8/3/2026, 12:49:34 PM
class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        solve(0, leftRow, lowerDiagonal, upperDiagonal, n);
        return count;
    }

    private void solve(int col, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal, int n) {
        if (col == n) {
            count++;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 + col - row]) {
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n - 1 + col - row] = true;

                solve(col + 1, leftRow, lowerDiagonal, upperDiagonal, n);

                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n - 1 + col - row] = false;
            }
        }
    }
}

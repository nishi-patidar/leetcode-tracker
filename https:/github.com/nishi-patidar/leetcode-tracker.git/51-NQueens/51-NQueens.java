// Last updated: 8/3/2026, 12:49:37 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal, n);
        return res;
    }
    
    private void solve(int col, char[][] board, List<List<String>> res, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal, int n) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 + col - row]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n - 1 + col - row] = true;
                
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal, n);
                
                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n - 1 + col - row] = false;
            }
        }
    }
}

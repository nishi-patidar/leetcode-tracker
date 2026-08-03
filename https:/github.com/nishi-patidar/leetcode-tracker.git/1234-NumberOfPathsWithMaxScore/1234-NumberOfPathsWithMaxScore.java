// Last updated: 8/3/2026, 12:48:07 PM
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] maxSum = new int[n][n];
        int[][] paths = new int[n][n];
        int MOD = 1000000007;

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxSum[i], -1);
        }
        
        maxSum[n - 1][n - 1] = 0;
        paths[n - 1][n - 1] = 1;
        
        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};
        
        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r == n - 1 && c == n - 1) {
                    continue;
                }
                
                char ch = board.get(r).charAt(c);
                if (ch == 'X') {
                    continue;
                }
                
                int max = -1;
                int p = 0;
                
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < n && nc < n && maxSum[nr][nc] != -1) {
                        if (maxSum[nr][nc] > max) {
                            max = maxSum[nr][nc];
                            p = paths[nr][nc];
                        } else if (maxSum[nr][nc] == max) {
                            p = (p + paths[nr][nc]) % MOD;
                        }
                    }
                }
                
                if (max != -1) {
                    maxSum[r][c] = max + (ch == 'E' ? 0 : ch - '0');
                    paths[r][c] = p;
                }
            }
        }
        
        if (paths[0][0] == 0) {
            return new int[]{0, 0};
        }
        
        return new int[]{maxSum[0][0], paths[0][0]};
    }
}

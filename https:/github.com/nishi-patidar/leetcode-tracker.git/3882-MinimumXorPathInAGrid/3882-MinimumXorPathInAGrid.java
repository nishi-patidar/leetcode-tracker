// Last updated: 10/30/2026, 8:36:38 PM
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] dp = new boolean[n][1024];
        int startVal = grid[0][0];
        dp[0][startVal] = true;
        
        for (int j = 1; j < n; j++) {
            for (int x = 0; x < 1024; x++) {
                if (dp[j - 1][x]) {
                    dp[j][x ^ grid[0][j]] = true;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            boolean[][] nextDp = new boolean[n][1024];
            
            for (int x = 0; x < 1024; x++) {
                if (dp[0][x]) {
                    nextDp[0][x ^ grid[i][0]] = true;
                }
            }
            
            for (int j = 1; j < n; j++) {
                for (int x = 0; x < 1024; x++) {
                    if (dp[j][x] || nextDp[j - 1][x]) {
                        nextDp[j][x ^ grid[i][j]] = true;
                    }
                }
            }
            
            dp = nextDp;
        }
        
        for (int x = 0; x < 1024; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }
        
        return 0;
    }
}
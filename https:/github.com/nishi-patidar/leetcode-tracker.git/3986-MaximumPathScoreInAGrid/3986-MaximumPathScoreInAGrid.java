// Last updated: 8/3/2026, 12:45:03 PM
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[j][c] will store the max score at column j with exact cost c
        int[][] dp = new int[n][k + 1];
        
        for (int j = 0; j < n; j++) {
            for (int c = 0; c <= k; c++) {
                dp[j][c] = -1;
            }
        }
        
        // Start point
        dp[0][0] = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip the top-left cell as it's our starting point (0 cost, 0 score)
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int cost = grid[i][j] == 0 ? 0 : 1;
                int score = grid[i][j];
                
                // We need a temporary array for the new state of the current cell
                // to avoid overwriting values we still need to read for the row transition.
                int[] nextDp = new int[k + 1];
                for (int c = 0; c <= k; c++) {
                    nextDp[c] = -1;
                }
                
                for (int c = cost; c <= k; c++) {
                    int maxPrev = -1;
                    
                    // Check path coming from above
                    if (dp[j][c - cost] != -1) {
                        maxPrev = Math.max(maxPrev, dp[j][c - cost]);
                    }
                    // Check path coming from the left
                    if (j > 0 && dp[j - 1][c - cost] != -1) {
                        maxPrev = Math.max(maxPrev, dp[j - 1][c - cost]);
                    }
                    
                    if (maxPrev != -1) {
                        nextDp[c] = maxPrev + score;
                    }
                }
                
                // Update the DP table for the current column
                dp[j] = nextDp;
            }
        }
        
        int maxScore = -1;
        // Check all possible costs up to k at the bottom-right cell
        for (int c = 0; c <= k; c++) {
            maxScore = Math.max(maxScore, dp[n - 1][c]);
        }
        
        return maxScore;
    }
}

// Last updated: 8/3/2026, 12:46:16 PM
class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        if (n <= 1) return 0;
        
        long[][] pref = new long[n][n + 1];
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                pref[c][r + 1] = pref[c][r] + grid[r][c];
            }
        }
        
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        
        for (int j = 0; j <= n; j++) {
            for (int k = 0; k <= n; k++) {
                long cost = (k > j) ? (pref[0][k] - pref[0][j]) : 0;
                dp[j][k] = cost;
            }
        }
        
        for (int c = 1; c < n - 1; c++) {
            long[][] new_dp = new long[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    new_dp[i][j] = -1;
                }
            }
            
            for (int j = 0; j <= n; j++) {
                long[] prefMax = new long[n + 1];
                long mx = -1;
                for (int i = 0; i <= n; i++) {
                    if (dp[i][j] > mx) mx = dp[i][j];
                    prefMax[i] = mx;
                }
                
                long[] suffMax = new long[n + 2];
                suffMax[n + 1] = -1;
                mx = -1;
                for (int i = n; i >= 0; i--) {
                    if (dp[i][j] != -1) {
                        long cost_i = (i > j) ? (pref[c][i] - pref[c][j]) : 0;
                        if (dp[i][j] + cost_i > mx) {
                            mx = dp[i][j] + cost_i;
                        }
                    }
                    suffMax[i] = mx;
                }
                
                for (int k = 0; k <= n; k++) {
                    long maxVal = -1;
                    long cost_k = (k > j) ? (pref[c][k] - pref[c][j]) : 0;
                    
                    if (prefMax[k] != -1) {
                        maxVal = prefMax[k] + cost_k;
                    }
                    if (k + 1 <= n && suffMax[k + 1] != -1) {
                        if (suffMax[k + 1] > maxVal) {
                            maxVal = suffMax[k + 1];
                        }
                    }
                    new_dp[j][k] = maxVal;
                }
            }
            dp = new_dp;
        }
        
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] != -1) {
                    long cost = (i > j) ? (pref[n - 1][i] - pref[n - 1][j]) : 0;
                    if (dp[i][j] + cost > ans) {
                        ans = dp[i][j] + cost;
                    }
                }
            }
        }
        
        return ans;
    }
}

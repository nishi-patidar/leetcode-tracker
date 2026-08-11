// Last updated: 8/11/2026, 1:50:55 PM
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return solve(0, 1, dp, suffixSum);
    }
    
    private int solve(int i, int M, int[][] dp, int[] suffixSum) {
        if (i + 2 * M >= suffixSum.length) {
            return suffixSum[i];
        }
        
        if (dp[i][M] != 0) {
            return dp[i][M];
        }
        
        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            maxStones = Math.max(maxStones, suffixSum[i] - solve(i + x, Math.max(M, x), dp, suffixSum));
        }
        
        dp[i][M] = maxStones;
        return maxStones;
    }
}
// Last updated: 8/9/2026, 4:31:14 PM
1class Solution {
2    public int stoneGameII(int[] piles) {
3        int n = piles.length;
4        int[][] dp = new int[n][n + 1];
5        int[] suffixSum = new int[n];
6        
7        suffixSum[n - 1] = piles[n - 1];
8        for (int i = n - 2; i >= 0; i--) {
9            suffixSum[i] = suffixSum[i + 1] + piles[i];
10        }
11        
12        return solve(0, 1, dp, suffixSum);
13    }
14    
15    private int solve(int i, int M, int[][] dp, int[] suffixSum) {
16        if (i + 2 * M >= suffixSum.length) {
17            return suffixSum[i];
18        }
19        
20        if (dp[i][M] != 0) {
21            return dp[i][M];
22        }
23        
24        int maxStones = 0;
25        for (int x = 1; x <= 2 * M; x++) {
26            maxStones = Math.max(maxStones, suffixSum[i] - solve(i + x, Math.max(M, x), dp, suffixSum));
27        }
28        
29        dp[i][M] = maxStones;
30        return maxStones;
31    }
32}
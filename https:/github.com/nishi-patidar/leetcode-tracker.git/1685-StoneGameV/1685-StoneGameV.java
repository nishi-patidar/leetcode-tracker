// Last updated: 8/19/2026, 8:59:46 PM
class Solution {
    int[][] memo;
    int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        
        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        if (i == j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxScore = 0;
        
        for (int k = i; k < j; k++) {
            int leftSum = prefixSum[k + 1] - prefixSum[i];
            int rightSum = prefixSum[j + 1] - prefixSum[k + 1];

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(i, k));
            } else if (leftSum > rightSum) {
                maxScore = Math.max(maxScore, rightSum + solve(k + 1, j));
            } else {
                maxScore = Math.max(maxScore, leftSum + Math.max(solve(i, k), solve(k + 1, j)));
            }
        }

        memo[i][j] = maxScore;
        return maxScore;
    }
}
// Last updated: 8/17/2026, 12:35:29 PM
1class Solution {
2    int[][] memo;
3    int[] prefixSum;
4
5    public int stoneGameV(int[] stoneValue) {
6        int n = stoneValue.length;
7        memo = new int[n][n];
8        prefixSum = new int[n + 1];
9        
10        for (int i = 0; i < n; i++) {
11            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
12        }
13        
14        return solve(0, n - 1);
15    }
16
17    private int solve(int i, int j) {
18        if (i == j) {
19            return 0;
20        }
21        if (memo[i][j] != 0) {
22            return memo[i][j];
23        }
24
25        int maxScore = 0;
26        
27        for (int k = i; k < j; k++) {
28            int leftSum = prefixSum[k + 1] - prefixSum[i];
29            int rightSum = prefixSum[j + 1] - prefixSum[k + 1];
30
31            if (leftSum < rightSum) {
32                maxScore = Math.max(maxScore, leftSum + solve(i, k));
33            } else if (leftSum > rightSum) {
34                maxScore = Math.max(maxScore, rightSum + solve(k + 1, j));
35            } else {
36                maxScore = Math.max(maxScore, leftSum + Math.max(solve(i, k), solve(k + 1, j)));
37            }
38        }
39
40        memo[i][j] = maxScore;
41        return maxScore;
42    }
43}
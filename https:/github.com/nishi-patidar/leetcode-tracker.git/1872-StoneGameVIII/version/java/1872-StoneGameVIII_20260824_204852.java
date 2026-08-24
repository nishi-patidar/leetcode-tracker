// Last updated: 8/24/2026, 8:48:52 PM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int n = stones.length;
4        
5        for (int i = 1; i < n; i++) {
6            stones[i] += stones[i - 1];
7        }
8        
9        int res = stones[n - 1];
10        
11        for (int i = n - 2; i > 0; i--) {
12            res = Math.max(res, stones[i] - res);
13        }
14        
15        return res;
16    }
17}
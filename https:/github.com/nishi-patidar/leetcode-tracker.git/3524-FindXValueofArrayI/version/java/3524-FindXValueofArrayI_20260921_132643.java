// Last updated: 9/21/2026, 1:26:43 PM
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3        long[] result = new long[k];
4        long[] dp = new long[k];
5        long[] nextDp = new long[k];
6        
7        int[][] trans = new int[k][k];
8        for (int i = 0; i < k; i++) {
9            for (int j = 0; j < k; j++) {
10                trans[i][j] = (i * j) % k;
11            }
12        }
13        
14        for (int i = 0; i < nums.length; i++) {
15            int val = nums[i] % k;
16            int[] t = trans[val];
17            
18            for (int j = 0; j < k; j++) {
19                nextDp[j] = 0;
20            }
21            
22            nextDp[val] = 1;
23            
24            for (int j = 0; j < k; j++) {
25                if (dp[j] > 0) {
26                    nextDp[t[j]] += dp[j];
27                }
28            }
29            
30            for (int j = 0; j < k; j++) {
31                result[j] += nextDp[j];
32                dp[j] = nextDp[j];
33            }
34        }
35        
36        return result;
37    }
38}
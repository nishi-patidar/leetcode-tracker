// Last updated: 9/6/2026, 11:31:13 AM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int sLen = s.length();
4        int tLen = t.length();
5        
6        if (sLen < tLen) {
7            return 0;
8        }
9        
10        char[] sArr = s.toCharArray();
11        char[] tArr = t.toCharArray();
12        int[] dp = new int[tLen + 1];
13        dp[0] = 1;
14        
15        for (int i = 0; i < sLen; i++) {
16            char c = sArr[i];
17            int maxJ = i + 1 < tLen ? i + 1 : tLen;
18            int minJ = tLen - sLen + i + 1;
19            
20            if (minJ < 1) {
21                minJ = 1;
22            }
23            
24            for (int j = maxJ; j >= minJ; j--) {
25                if (c == tArr[j - 1]) {
26                    dp[j] += dp[j - 1];
27                }
28            }
29        }
30        
31        return dp[tLen];
32    }
33}
// Last updated: 10/1/2026, 3:03:38 PM
class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        if (sLen < tLen) {
            return 0;
        }
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] dp = new int[tLen + 1];
        dp[0] = 1;
        
        for (int i = 0; i < sLen; i++) {
            char c = sArr[i];
            int maxJ = i + 1 < tLen ? i + 1 : tLen;
            int minJ = tLen - sLen + i + 1;
            
            if (minJ < 1) {
                minJ = 1;
            }
            
            for (int j = maxJ; j >= minJ; j--) {
                if (c == tArr[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[tLen];
    }
}
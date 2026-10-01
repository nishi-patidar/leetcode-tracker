// Last updated: 10/1/2026, 3:03:06 PM
class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int[] dp = new int[26];
        int total = 0;
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            int old = dp[idx];
            
            int next = total + 1;
            if (next == mod) {
                next = 0;
            }
            
            dp[idx] = next;
            
            total = total + next - old;
            if (total >= mod) {
                total -= mod;
            } else if (total < 0) {
                total += mod;
            }
        }
        
        return total;
    }
}
// Last updated: 9/7/2026, 8:24:47 AM
1class Solution {
2    public int distinctSubseqII(String s) {
3        int mod = 1000000007;
4        int[] dp = new int[26];
5        int total = 0;
6        
7        for (char c : s.toCharArray()) {
8            int idx = c - 'a';
9            int old = dp[idx];
10            
11            int next = total + 1;
12            if (next == mod) {
13                next = 0;
14            }
15            
16            dp[idx] = next;
17            
18            total = total + next - old;
19            if (total >= mod) {
20                total -= mod;
21            } else if (total < 0) {
22                total += mod;
23            }
24        }
25        
26        return total;
27    }
28}
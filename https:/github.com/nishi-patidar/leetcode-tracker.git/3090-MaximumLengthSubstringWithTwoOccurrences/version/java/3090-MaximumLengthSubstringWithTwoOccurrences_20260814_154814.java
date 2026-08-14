// Last updated: 8/14/2026, 3:48:14 PM
1class Solution {
2    public int maximumLengthSubstring(String s) {
3        int maxLen = 0;
4        int left = 0;
5        int[] count = new int[26];
6        
7        for (int right = 0; right < s.length(); right++) {
8            count[s.charAt(right) - 'a']++;
9            
10            while (count[s.charAt(right) - 'a'] > 2) {
11                count[s.charAt(left) - 'a']--;
12                left++;
13            }
14            
15            maxLen = Math.max(maxLen, right - left + 1);
16        }
17        
18        return maxLen;
19    }
20}
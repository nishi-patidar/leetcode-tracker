// Last updated: 8/26/2026, 5:06:08 PM
1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        int left = 0;
4        int ones = 0;
5        int minLen = Integer.MAX_VALUE;
6        String best = "";
7
8        char[] chars = s.toCharArray();
9        int n = chars.length;
10
11        for (int right = 0; right < n; right++) {
12            if (chars[right] == '1') {
13                ones++;
14            }
15            
16            while (ones == k) {
17                while (chars[left] == '0') {
18                    left++;
19                }
20                
21                int len = right - left + 1;
22                
23                if (len < minLen) {
24                    minLen = len;
25                    best = s.substring(left, right + 1);
26                } else if (len == minLen) {
27                    String current = s.substring(left, right + 1);
28                    if (current.compareTo(best) < 0) {
29                        best = current;
30                    }
31                }
32                
33                ones--;
34                left++;
35            }
36        }
37        
38        return best;
39    }
40}
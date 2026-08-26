// Last updated: 8/26/2026, 5:03:20 PM
1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        String best = "";
4        int minLen = Integer.MAX_VALUE;
5
6        for (int i = 0; i < s.length(); i++) {
7            int count = 0;
8            for (int j = i; j < s.length(); j++) {
9                if (s.charAt(j) == '1') {
10                    count++;
11                }
12                if (count == k) {
13                    int len = j - i + 1;
14                    String sub = s.substring(i, j + 1);
15                    if (len < minLen) {
16                        minLen = len;
17                        best = sub;
18                    } else if (len == minLen) {
19                        if (sub.compareTo(best) < 0) {
20                            best = sub;
21                        }
22                    }
23                    break;
24                }
25            }
26        }
27        return best;
28    }
29}
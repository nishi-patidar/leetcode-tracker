// Last updated: 8/17/2026, 12:33:44 PM
1class Solution {
2    public String minWindow(String s, String t) {
3        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
4            return "";
5        }
6
7        int[] map = new int[128];
8        for (char c : t.toCharArray()) {
9            map[c]++;
10        }
11
12        int left = 0;
13        int right = 0;
14        int minLeft = 0;
15        int minLen = Integer.MAX_VALUE;
16        int count = t.length();
17
18        while (right < s.length()) {
19            char c1 = s.charAt(right);
20            if (map[c1] > 0) {
21                count--;
22            }
23            map[c1]--;
24            right++;
25
26            while (count == 0) {
27                if (right - left < minLen) {
28                    minLen = right - left;
29                    minLeft = left;
30                }
31                char c2 = s.charAt(left);
32                map[c2]++;
33                if (map[c2] > 0) {
34                    count++;
35                }
36                left++;
37            }
38        }
39        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
40    }
41}
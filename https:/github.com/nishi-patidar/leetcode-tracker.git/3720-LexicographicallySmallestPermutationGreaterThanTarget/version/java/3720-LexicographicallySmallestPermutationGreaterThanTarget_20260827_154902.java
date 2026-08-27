// Last updated: 8/27/2026, 3:49:02 PM
1class Solution {
2    public String lexGreaterPermutation(String s, String target) {
3        char[] sArr = s.toCharArray();
4        char[] tArr = target.toCharArray();
5        int n = sArr.length;
6        
7        int[] counts = new int[26];
8        for (char c : sArr) {
9            counts[c - 'a']++;
10        }
11        
12        int bestI = -1;
13        char bestChar = 0;
14        
15        for (int i = 0; i < n; i++) {
16            int tc = tArr[i] - 'a';
17            
18            for (int c = tc + 1; c < 26; c++) {
19                if (counts[c] > 0) {
20                    bestI = i;
21                    bestChar = (char) (c + 'a');
22                    break;
23                }
24            }
25            
26            if (counts[tc] > 0) {
27                counts[tc]--;
28            } else {
29                break;
30            }
31        }
32        
33        if (bestI == -1) {
34            return "";
35        }
36        
37        char[] res = new char[n];
38        int[] remain = new int[26];
39        for (char c : sArr) {
40            remain[c - 'a']++;
41        }
42        
43        for (int i = 0; i < bestI; i++) {
44            res[i] = tArr[i];
45            remain[res[i] - 'a']--;
46        }
47        
48        res[bestI] = bestChar;
49        remain[bestChar - 'a']--;
50        
51        int idx = bestI + 1;
52        for (int c = 0; c < 26; c++) {
53            while (remain[c] > 0) {
54                res[idx++] = (char) (c + 'a');
55                remain[c]--;
56            }
57        }
58        
59        return new String(res);
60    }
61}
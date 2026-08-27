// Last updated: 8/27/2026, 3:48:17 PM
1class Solution {
2    public String lexGreaterPermutation(String s, String target) {
3        int n = s.length();
4        int[] count = new int[26];
5        for (char c : s.toCharArray()) {
6            count[c - 'a']++;
7        }
8
9        int best_i = -1;
10        char best_char = ' ';
11
12        for (int i = 0; i < n; i++) {
13            char tc = target.charAt(i);
14            
15            for (int c = tc - 'a' + 1; c < 26; c++) {
16                if (count[c] > 0) {
17                    best_i = i;
18                    best_char = (char) (c + 'a');
19                    break;
20                }
21            }
22
23            if (count[tc - 'a'] > 0) {
24                count[tc - 'a']--;
25            } else {
26                break;
27            }
28        }
29
30        if (best_i == -1) {
31            return "";
32        }
33
34        StringBuilder sb = new StringBuilder();
35        sb.append(target.substring(0, best_i));
36        sb.append(best_char);
37
38        int[] remain = new int[26];
39        for (char c : s.toCharArray()) {
40            remain[c - 'a']++;
41        }
42        for (int i = 0; i < best_i; i++) {
43            remain[target.charAt(i) - 'a']--;
44        }
45        remain[best_char - 'a']--;
46
47        for (int c = 0; c < 26; c++) {
48            while (remain[c] > 0) {
49                sb.append((char) (c + 'a'));
50                remain[c]--;
51            }
52        }
53
54        return sb.toString();
55    }
56}
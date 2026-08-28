// Last updated: 8/28/2026, 8:50:30 AM
1class Solution {
2    public String lexPalindromicPermutation(String s, String target) {
3        int n = s.length();
4        int[] counts = new int[26];
5        for (char c : s.toCharArray()) {
6            counts[c - 'a']++;
7        }
8
9        int oddCount = 0;
10        char midChar = 0;
11        for (int i = 0; i < 26; i++) {
12            if (counts[i] % 2 != 0) {
13                oddCount++;
14                midChar = (char) (i + 'a');
15            }
16        }
17
18        if (oddCount > 1) {
19            return "";
20        }
21
22        int[] halfCounts = new int[26];
23        for (int i = 0; i < 26; i++) {
24            halfCounts[i] = counts[i] / 2;
25        }
26
27        int m = n / 2;
28        boolean canMatchExact = true;
29        int[] tempCounts = halfCounts.clone();
30        char[] exactHalf = new char[m];
31        
32        for (int i = 0; i < m; i++) {
33            int c = target.charAt(i) - 'a';
34            if (tempCounts[c] > 0) {
35                tempCounts[c]--;
36                exactHalf[i] = (char) (c + 'a');
37            } else {
38                canMatchExact = false;
39                break;
40            }
41        }
42
43        if (canMatchExact) {
44            char[] full = new char[n];
45            for (int i = 0; i < m; i++) {
46                full[i] = exactHalf[i];
47                full[n - 1 - i] = exactHalf[i];
48            }
49            if (n % 2 != 0) {
50                full[m] = midChar;
51            }
52            String fullStr = new String(full);
53            if (fullStr.compareTo(target) > 0) {
54                return fullStr;
55            }
56        }
57
58        int bestI = -1;
59        char bestChar = 0;
60        tempCounts = halfCounts.clone();
61
62        for (int i = 0; i < m; i++) {
63            int tc = target.charAt(i) - 'a';
64            
65            for (int c = tc + 1; c < 26; c++) {
66                if (tempCounts[c] > 0) {
67                    bestI = i;
68                    bestChar = (char) (c + 'a');
69                    break;
70                }
71            }
72
73            if (tempCounts[tc] > 0) {
74                tempCounts[tc]--;
75            } else {
76                break;
77            }
78        }
79
80        if (bestI == -1) {
81            return "";
82        }
83
84        tempCounts = halfCounts.clone();
85        char[] resHalf = new char[m];
86        
87        for (int i = 0; i < bestI; i++) {
88            resHalf[i] = target.charAt(i);
89            tempCounts[target.charAt(i) - 'a']--;
90        }
91        
92        resHalf[bestI] = bestChar;
93        tempCounts[bestChar - 'a']--;
94        
95        int idx = bestI + 1;
96        for (int c = 0; c < 26; c++) {
97            while (tempCounts[c] > 0) {
98                resHalf[idx++] = (char) (c + 'a');
99                tempCounts[c]--;
100            }
101        }
102
103        char[] fullRes = new char[n];
104        for (int i = 0; i < m; i++) {
105            fullRes[i] = resHalf[i];
106            fullRes[n - 1 - i] = resHalf[i];
107        }
108        if (n % 2 != 0) {
109            fullRes[m] = midChar;
110        }
111
112        return new String(fullRes);
113    }
114}
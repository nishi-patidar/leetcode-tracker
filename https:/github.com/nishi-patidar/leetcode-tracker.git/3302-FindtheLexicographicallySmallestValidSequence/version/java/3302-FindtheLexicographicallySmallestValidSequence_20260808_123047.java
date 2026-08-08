// Last updated: 8/8/2026, 12:30:47 PM
1class Solution {
2    public int[] validSequence(String word1, String word2) {
3        int M = word1.length();
4        int N = word2.length();
5        int[] R = new int[M + 1];
6        int jSuf = N - 1;
7        
8        for (int i = M - 1; i >= 0; i--) {
9            if (jSuf >= 0 && word1.charAt(i) == word2.charAt(jSuf)) {
10                jSuf--;
11            }
12            R[i] = N - 1 - jSuf;
13        }
14        
15        int[] res = new int[N];
16        int j = 0;
17        boolean changed = false;
18        
19        for (int i = 0; i < M; i++) {
20            if (j == N) break;
21            
22            if (changed) {
23                if (word1.charAt(i) == word2.charAt(j)) {
24                    res[j] = i;
25                    j++;
26                }
27            } else {
28                if (word1.charAt(i) == word2.charAt(j)) {
29                    res[j] = i;
30                    j++;
31                } else if (R[i + 1] >= N - 1 - j) {
32                    res[j] = i;
33                    j++;
34                    changed = true;
35                }
36            }
37        }
38        
39        if (j == N) {
40            return res;
41        }
42        
43        return new int[0];
44    }
45}
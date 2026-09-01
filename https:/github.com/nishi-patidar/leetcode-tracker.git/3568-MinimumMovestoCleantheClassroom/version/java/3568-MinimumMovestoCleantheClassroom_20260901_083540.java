// Last updated: 9/1/2026, 8:35:40 AM
1import java.util.Arrays;
2
3class Solution {
4    public int minMoves(String[] classroom, int energy) {
5        int m = classroom.length;
6        int n = classroom[0].length();
7        int width = n + 2;
8        int totalCells = (m + 2) * width;
9
10        byte[] type = new byte[totalCells];
11        int[] litter = new int[totalCells];
12        int lCount = 0;
13        int startPos = -1;
14
15        for (int i = 0; i < m; i++) {
16            String row = classroom[i];
17            for (int j = 0; j < n; j++) {
18                char c = row.charAt(j);
19                int pos = (i + 1) * width + (j + 1);
20                if (c == 'X') {
21                    type[pos] = 0;
22                } else if (c == '.') {
23                    type[pos] = 1;
24                } else if (c == 'S') {
25                    type[pos] = 1;
26                    startPos = pos;
27                } else if (c == 'L') {
28                    type[pos] = 1;
29                    litter[pos] = 1 << lCount;
30                    lCount++;
31                } else if (c == 'R') {
32                    type[pos] = 2;
33                }
34            }
35        }
36
37        if (lCount == 0) {
38            return 0;
39        }
40        
41        int targetMask = (1 << lCount) - 1;
42
43        int[] currQ = new int[524288];
44        int[] nextQ = new int[524288];
45        byte[] maxE = new byte[524288];
46        int[] lastAdded = new int[524288];
47
48        Arrays.fill(maxE, (byte) -1);
49        
50        int currSz = 0;
51        currQ[currSz++] = startPos;
52        maxE[startPos] = (byte) energy;
53        lastAdded[startPos] = 0;
54
55        int moves = 0;
56
57        while (currSz > 0) {
58            int nextSz = 0;
59            moves++;
60            
61            for (int i = 0; i < currSz; i++) {
62                int state = currQ[i];
63                int e = maxE[state];
64
65                if (e == 0) {
66                    continue;
67                }
68
69                int pos = state & 511;
70                int mask = state >> 9;
71                int nextE = e - 1;
72                
73                int npos, t, ne, nmask, nstate;
74
75                npos = pos - width;
76                t = type[npos];
77                if (t != 0) {
78                    ne = (t == 2) ? energy : nextE;
79                    nmask = mask | litter[npos];
80                    if (nmask == targetMask) return moves;
81                    nstate = npos | (nmask << 9);
82                    if (ne > maxE[nstate]) {
83                        maxE[nstate] = (byte) ne;
84                        if (lastAdded[nstate] != moves) {
85                            lastAdded[nstate] = moves;
86                            nextQ[nextSz++] = nstate;
87                        }
88                    }
89                }
90
91                npos = pos + width;
92                t = type[npos];
93                if (t != 0) {
94                    ne = (t == 2) ? energy : nextE;
95                    nmask = mask | litter[npos];
96                    if (nmask == targetMask) return moves;
97                    nstate = npos | (nmask << 9);
98                    if (ne > maxE[nstate]) {
99                        maxE[nstate] = (byte) ne;
100                        if (lastAdded[nstate] != moves) {
101                            lastAdded[nstate] = moves;
102                            nextQ[nextSz++] = nstate;
103                        }
104                    }
105                }
106
107                npos = pos - 1;
108                t = type[npos];
109                if (t != 0) {
110                    ne = (t == 2) ? energy : nextE;
111                    nmask = mask | litter[npos];
112                    if (nmask == targetMask) return moves;
113                    nstate = npos | (nmask << 9);
114                    if (ne > maxE[nstate]) {
115                        maxE[nstate] = (byte) ne;
116                        if (lastAdded[nstate] != moves) {
117                            lastAdded[nstate] = moves;
118                            nextQ[nextSz++] = nstate;
119                        }
120                    }
121                }
122
123                npos = pos + 1;
124                t = type[npos];
125                if (t != 0) {
126                    ne = (t == 2) ? energy : nextE;
127                    nmask = mask | litter[npos];
128                    if (nmask == targetMask) return moves;
129                    nstate = npos | (nmask << 9);
130                    if (ne > maxE[nstate]) {
131                        maxE[nstate] = (byte) ne;
132                        if (lastAdded[nstate] != moves) {
133                            lastAdded[nstate] = moves;
134                            nextQ[nextSz++] = nstate;
135                        }
136                    }
137                }
138            }
139
140            int[] temp = currQ;
141            currQ = nextQ;
142            nextQ = temp;
143            currSz = nextSz;
144        }
145
146        return -1;
147    }
148}
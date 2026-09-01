// Last updated: 9/1/2026, 8:32:19 AM
1import java.util.Arrays;
2
3class Solution {
4    public int minMoves(String[] classroom, int energy) {
5        int m = classroom.length;
6        int n = classroom[0].length();
7        
8        char[][] grid = new char[m][n];
9        int[][] lMask = new int[m][n];
10        int lCount = 0;
11        int startR = -1, startC = -1;
12        
13        for (int i = 0; i < m; i++) {
14            String row = classroom[i];
15            for (int j = 0; j < n; j++) {
16                char c = row.charAt(j);
17                grid[i][j] = c;
18                if (c == 'S') {
19                    startR = i; 
20                    startC = j;
21                } else if (c == 'L') {
22                    lMask[i][j] = 1 << lCount;
23                    lCount++;
24                }
25            }
26        }
27        
28        if (lCount == 0) {
29            return 0;
30        }
31        
32        int targetMask = (1 << lCount) - 1;
33        
34        byte[] maxE = new byte[m * n * (1 << lCount)];
35        Arrays.fill(maxE, (byte) -1);
36        
37        int qCap = 4194304; 
38        int[] q = new int[qCap];
39        int qMask = qCap - 1;
40        int head = 0, tail = 0;
41        
42        q[tail++] = (energy << 20) | (startR << 5) | startC;
43        maxE[((startR * n + startC) << lCount)] = (byte) energy;
44        
45        int moves = 0;
46        
47        while (head < tail) {
48            int size = tail - head;
49            for (int i = 0; i < size; i++) {
50                int state = q[head & qMask];
51                head++;
52                
53                int c = state & 31;
54                int r = (state >> 5) & 31;
55                int mask = (state >> 10) & 1023;
56                int currE = (state >> 20) & 63;
57                
58                if (currE == 0) {
59                    continue;
60                }
61                
62                int nextE = currE - 1;
63                
64                if (r > 0 && grid[r - 1][c] != 'X') {
65                    int nr = r - 1;
66                    char cell = grid[nr][c];
67                    int e = (cell == 'R') ? energy : nextE;
68                    int msk = mask | lMask[nr][c];
69                    if (msk == targetMask) {
70                        return moves + 1;
71                    }
72                    int sIdx = ((nr * n + c) << lCount) | msk;
73                    if (e > maxE[sIdx]) {
74                        maxE[sIdx] = (byte) e;
75                        q[tail & qMask] = (e << 20) | (msk << 10) | (nr << 5) | c;
76                        tail++;
77                    }
78                }
79                
80                if (r < m - 1 && grid[r + 1][c] != 'X') {
81                    int nr = r + 1;
82                    char cell = grid[nr][c];
83                    int e = (cell == 'R') ? energy : nextE;
84                    int msk = mask | lMask[nr][c];
85                    if (msk == targetMask) {
86                        return moves + 1;
87                    }
88                    int sIdx = ((nr * n + c) << lCount) | msk;
89                    if (e > maxE[sIdx]) {
90                        maxE[sIdx] = (byte) e;
91                        q[tail & qMask] = (e << 20) | (msk << 10) | (nr << 5) | c;
92                        tail++;
93                    }
94                }
95                
96                if (c > 0 && grid[r][c - 1] != 'X') {
97                    int nc = c - 1;
98                    char cell = grid[r][nc];
99                    int e = (cell == 'R') ? energy : nextE;
100                    int msk = mask | lMask[r][nc];
101                    if (msk == targetMask) {
102                        return moves + 1;
103                    }
104                    int sIdx = ((r * n + nc) << lCount) | msk;
105                    if (e > maxE[sIdx]) {
106                        maxE[sIdx] = (byte) e;
107                        q[tail & qMask] = (e << 20) | (msk << 10) | (r << 5) | nc;
108                        tail++;
109                    }
110                }
111                
112                if (c < n - 1 && grid[r][c + 1] != 'X') {
113                    int nc = c + 1;
114                    char cell = grid[r][nc];
115                    int e = (cell == 'R') ? energy : nextE;
116                    int msk = mask | lMask[r][nc];
117                    if (msk == targetMask) {
118                        return moves + 1;
119                    }
120                    int sIdx = ((r * n + nc) << lCount) | msk;
121                    if (e > maxE[sIdx]) {
122                        maxE[sIdx] = (byte) e;
123                        q[tail & qMask] = (e << 20) | (msk << 10) | (r << 5) | nc;
124                        tail++;
125                    }
126                }
127            }
128            moves++;
129        }
130        
131        return -1;
132    }
133}
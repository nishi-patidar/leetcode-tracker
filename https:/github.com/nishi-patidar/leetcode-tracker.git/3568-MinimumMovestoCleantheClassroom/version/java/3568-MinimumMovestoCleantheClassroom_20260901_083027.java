// Last updated: 9/1/2026, 8:30:27 AM
1class Solution {
2    public int minMoves(String[] classroom, int energy) {
3        int m = classroom.length;
4        int n = classroom[0].length();
5        int lCount = 0;
6        int[][] lIndices = new int[m][n];
7        
8        int startR = -1, startC = -1;
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11                char c = classroom[i].charAt(j);
12                if (c == 'S') {
13                    startR = i; 
14                    startC = j;
15                } else if (c == 'L') {
16                    lIndices[i][j] = lCount++;
17                }
18            }
19        }
20        
21        if (lCount == 0) {
22            return 0;
23        }
24        
25        int[][][] maxEnergy = new int[m][n][1 << lCount];
26        for (int i = 0; i < m; i++) {
27            for (int j = 0; j < n; j++) {
28                for (int k = 0; k < (1 << lCount); k++) {
29                    maxEnergy[i][j][k] = -1;
30                }
31            }
32        }
33        
34        int targetMask = (1 << lCount) - 1;
35        int[] q = new int[5000000];
36        int head = 0, tail = 0;
37        
38        q[tail++] = (energy << 20) | (0 << 10) | (startC << 5) | startR;
39        maxEnergy[startR][startC][0] = energy;
40        
41        int moves = 0;
42        int[] dr = {-1, 1, 0, 0};
43        int[] dc = {0, 0, -1, 1};
44        
45        while (head < tail) {
46            int size = tail - head;
47            for (int i = 0; i < size; i++) {
48                int state = q[head++];
49                int r = state & 31;
50                int c = (state >> 5) & 31;
51                int mask = (state >> 10) & 1023;
52                int currE = (state >> 20) & 63;
53                
54                if (currE == 0) {
55                    continue;
56                }
57                
58                for (int d = 0; d < 4; d++) {
59                    int nr = r + dr[d];
60                    int nc = c + dc[d];
61                    
62                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
63                        char nextCell = classroom[nr].charAt(nc);
64                        if (nextCell == 'X') {
65                            continue;
66                        }
67                        
68                        int nextE = currE - 1;
69                        if (nextCell == 'R') {
70                            nextE = energy;
71                        }
72                        
73                        int nextMask = mask;
74                        if (nextCell == 'L') {
75                            nextMask |= (1 << lIndices[nr][nc]);
76                        }
77                        
78                        if (nextMask == targetMask) {
79                            return moves + 1;
80                        }
81                        
82                        if (nextE > maxEnergy[nr][nc][nextMask]) {
83                            maxEnergy[nr][nc][nextMask] = nextE;
84                            q[tail++] = (nextE << 20) | (nextMask << 10) | (nc << 5) | nr;
85                        }
86                    }
87                }
88            }
89            moves++;
90        }
91        
92        return -1;
93    }
94}
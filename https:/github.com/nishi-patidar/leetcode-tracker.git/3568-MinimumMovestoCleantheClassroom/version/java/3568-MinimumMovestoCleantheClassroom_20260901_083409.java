// Last updated: 9/1/2026, 8:34:09 AM
1import java.util.Arrays;
2
3class Solution {
4    public int minMoves(String[] classroom, int energy) {
5        int m = classroom.length;
6        int n = classroom[0].length();
7        int totalCells = m * n;
8
9        char[] grid = new char[totalCells];
10        int[] lMask = new int[totalCells];
11        int lCount = 0;
12        int startPos = -1;
13
14        for (int i = 0; i < m; i++) {
15            String row = classroom[i];
16            for (int j = 0; j < n; j++) {
17                int pos = i * n + j;
18                char c = row.charAt(j);
19                grid[pos] = c;
20                if (c == 'S') {
21                    startPos = pos;
22                } else if (c == 'L') {
23                    lMask[pos] = 1 << lCount;
24                    lCount++;
25                }
26            }
27        }
28
29        if (lCount == 0) {
30            return 0;
31        }
32
33        int targetMask = (1 << lCount) - 1;
34        int[][] adj = new int[totalCells][];
35
36        for (int i = 0; i < m; i++) {
37            for (int j = 0; j < n; j++) {
38                int pos = i * n + j;
39                if (grid[pos] == 'X') {
40                    continue;
41                }
42                int[] neighbors = new int[4];
43                int count = 0;
44                if (i > 0 && grid[pos - n] != 'X') neighbors[count++] = pos - n;
45                if (i < m - 1 && grid[pos + n] != 'X') neighbors[count++] = pos + n;
46                if (j > 0 && grid[pos - 1] != 'X') neighbors[count++] = pos - 1;
47                if (j < n - 1 && grid[pos + 1] != 'X') neighbors[count++] = pos + 1;
48                adj[pos] = Arrays.copyOf(neighbors, count);
49            }
50        }
51
52        int ARRAY_SIZE = 524288;
53        byte[] maxE = new byte[ARRAY_SIZE];
54        Arrays.fill(maxE, (byte) -1);
55
56        int[] lastLevelAdded = new int[ARRAY_SIZE];
57        Arrays.fill(lastLevelAdded, -1);
58
59        int[] currQ = new int[ARRAY_SIZE];
60        int[] nextQ = new int[ARRAY_SIZE];
61
62        int currSize = 0;
63        int startState = startPos | (0 << 9);
64        currQ[currSize++] = startState;
65        maxE[startState] = (byte) energy;
66        lastLevelAdded[startState] = 0;
67
68        int moves = 0;
69
70        while (currSize > 0) {
71            int nextSize = 0;
72
73            for (int i = 0; i < currSize; i++) {
74                int state = currQ[i];
75                int currEnergy = maxE[state];
76
77                if (currEnergy == 0) {
78                    continue;
79                }
80
81                int pos = state & 511;
82                int mask = state >> 9;
83                int nextEnergy = currEnergy - 1;
84
85                for (int n_pos : adj[pos]) {
86                    int n_energy = (grid[n_pos] == 'R') ? energy : nextEnergy;
87                    int n_mask = mask | lMask[n_pos];
88
89                    if (n_mask == targetMask) {
90                        return moves + 1;
91                    }
92
93                    int n_state = n_pos | (n_mask << 9);
94
95                    if (n_energy > maxE[n_state]) {
96                        maxE[n_state] = (byte) n_energy;
97                        if (lastLevelAdded[n_state] != moves + 1) {
98                            lastLevelAdded[n_state] = moves + 1;
99                            nextQ[nextSize++] = n_state;
100                        }
101                    }
102                }
103            }
104
105            moves++;
106            int[] temp = currQ;
107            currQ = nextQ;
108            nextQ = temp;
109            currSize = nextSize;
110        }
111
112        return -1;
113    }
114}
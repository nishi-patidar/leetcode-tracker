// Last updated: 9/13/2026, 9:28:48 AM
1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4        int[] m1 = new int[n];
5        int[] m2 = new int[n];
6        
7        for (int i = 0; i < n; i++) {
8            int row1 = 0;
9            int row2 = 0;
10            for (int j = 0; j < n; j++) {
11                if (img1[i][j] == 1) {
12                    row1 |= (1 << j);
13                }
14                if (img2[i][j] == 1) {
15                    row2 |= (1 << j);
16                }
17            }
18            m1[i] = row1;
19            m2[i] = row2;
20        }
21        
22        int max = 0;
23        for (int y = 0; y < n; y++) {
24            for (int x = 0; x < n; x++) {
25                int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
26                for (int i = y; i < n; i++) {
27                    int r1 = m1[i - y];
28                    int r2 = m2[i];
29                    int r3 = m2[i - y];
30                    int r4 = m1[i];
31                    
32                    c1 += Integer.bitCount((r1 >>> x) & r2);
33                    c3 += Integer.bitCount((r1 << x) & r2);
34                    c2 += Integer.bitCount((r3 >>> x) & r4);
35                    c4 += Integer.bitCount((r3 << x) & r4);
36                }
37                if (c1 > max) max = c1;
38                if (c2 > max) max = c2;
39                if (c3 > max) max = c3;
40                if (c4 > max) max = c4;
41            }
42        }
43        
44        return max;
45    }
46}
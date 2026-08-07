// Last updated: 8/7/2026, 7:56:57 PM
1class Solution {
2    public void setZeroes(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        boolean firstRowZero = false;
6        
7        for (int j = 0; j < n; j++) {
8            if (matrix[0][j] == 0) {
9                firstRowZero = true;
10                break;
11            }
12        }
13        
14        for (int i = 1; i < m; i++) {
15            for (int j = 0; j < n; j++) {
16                if (matrix[i][j] == 0) {
17                    matrix[i][0] = 0;
18                    matrix[0][j] = 0;
19                }
20            }
21        }
22        
23        for (int i = 1; i < m; i++) {
24            for (int j = 1; j < n; j++) {
25                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
26                    matrix[i][j] = 0;
27                }
28            }
29        }
30        
31        if (matrix[0][0] == 0) {
32            for (int i = 0; i < m; i++) {
33                matrix[i][0] = 0;
34            }
35        }
36        
37        if (firstRowZero) {
38            for (int j = 0; j < n; j++) {
39                matrix[0][j] = 0;
40            }
41        }
42    }
43}
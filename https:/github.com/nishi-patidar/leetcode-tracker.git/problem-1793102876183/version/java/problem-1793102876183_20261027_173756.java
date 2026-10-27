// Last updated: 10/27/2026, 5:37:56 PM
1class Solution {
2    public String[] createGrid(int m, int n) {
3        String[] result = new String[m];
4        
5        for (int i = 0; i < m; i++) {
6            StringBuilder row = new StringBuilder();
7            for (int j = 0; j < n; j++) {
8                if (i == 0 || j == n - 1) {
9                    row.append('.');
10                } else {
11                    row.append('#');
12                }
13            }
14            result[i] = row.toString();
15        }
16        
17        return result;
18    }
19}
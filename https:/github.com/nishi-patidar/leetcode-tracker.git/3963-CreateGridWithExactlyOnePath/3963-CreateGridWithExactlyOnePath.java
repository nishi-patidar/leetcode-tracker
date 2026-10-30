// Last updated: 10/30/2026, 8:36:11 PM
class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        
        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    row.append('.');
                } else {
                    row.append('#');
                }
            }
            result[i] = row.toString();
        }
        
        return result;
    }
}
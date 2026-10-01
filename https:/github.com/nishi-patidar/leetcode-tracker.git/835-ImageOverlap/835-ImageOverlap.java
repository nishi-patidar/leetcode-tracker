// Last updated: 10/1/2026, 3:03:17 PM
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[] m1 = new int[n];
        int[] m2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            int row1 = 0;
            int row2 = 0;
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    row1 |= (1 << j);
                }
                if (img2[i][j] == 1) {
                    row2 |= (1 << j);
                }
            }
            m1[i] = row1;
            m2[i] = row2;
        }
        
        int max = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
                for (int i = y; i < n; i++) {
                    int r1 = m1[i - y];
                    int r2 = m2[i];
                    int r3 = m2[i - y];
                    int r4 = m1[i];
                    
                    c1 += Integer.bitCount((r1 >>> x) & r2);
                    c3 += Integer.bitCount((r1 << x) & r2);
                    c2 += Integer.bitCount((r3 >>> x) & r4);
                    c4 += Integer.bitCount((r3 << x) & r4);
                }
                if (c1 > max) max = c1;
                if (c2 > max) max = c2;
                if (c3 > max) max = c3;
                if (c4 > max) max = c4;
            }
        }
        
        return max;
    }
}
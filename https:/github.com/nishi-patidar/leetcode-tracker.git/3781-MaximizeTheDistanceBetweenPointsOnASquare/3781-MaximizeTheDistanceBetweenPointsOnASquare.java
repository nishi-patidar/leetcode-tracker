// Last updated: 8/3/2026, 12:45:58 PM
import java.util.Arrays;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] P = new long[n];
        
        for (int i = 0; i < n; i++) {
            long x = points[i][0];
            long y = points[i][1];
            long pos;
            
            if (y == 0) {
                pos = x;
            } else if (x == side) {
                pos = side + y;
            } else if (y == side) {
                pos = 3L * side - x;
            } else {
                pos = 4L * side - y;
            }
            
            P[i] = pos;
        }
        
        Arrays.sort(P);
        
        long[] A = new long[2 * n];
        for (int i = 0; i < n; i++) {
            A[i] = P[i];
            A[i + n] = P[i] + 4L * side;
        }
        
        long low = 1;
        long high = side;
        long ans = 1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(mid, A, n, k, side)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return (int) ans;
    }
    
    private boolean check(long d, long[] A, int n, int k, int side) {
        int m = 2 * n;
        int[] next = new int[m];
        int j = 0;
        
        for (int i = 0; i < m; i++) {
            while (j < m && A[j] - A[i] < d) {
                j++;
            }
            next[i] = j;
        }
        
        for (int i = 0; i < n; i++) {
            int curr = i;
            for (int step = 1; step < k; step++) {
                curr = next[curr];
                if (curr >= m) break;
            }
            if (curr < m && A[curr] <= A[i] + 4L * side - d) {
                return true;
            }
        }
        
        return false;
    }
}

// Last updated: 8/3/2026, 12:47:15 PM
import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int k = m * n;
        int[] arr = new int[k];
        
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }
        
        int mod = arr[0] % x;
        if (mod < 0) {
            mod += x;
        }
        
        for (int i = 1; i < k; i++) {
            int currentMod = arr[i] % x;
            if (currentMod < 0) {
                currentMod += x;
            }
            if (currentMod != mod) {
                return -1;
            }
        }
        
        Arrays.sort(arr);
        
        int median = arr[k / 2];
        int operations = 0;
        
        for (int i = 0; i < k; i++) {
            operations += Math.abs(arr[i] - median) / x;
        }
        
        return operations;
    }
}

// Last updated: 8/3/2026, 12:46:35 PM
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // If start or end contains a thief, max safeness is 0 instantly
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        
        // Using a flat array queue instead of LinkedList/Queue for massive speedup
        int[] q = new int[n * n];
        int head = 0, tail = 0;
        
        // Multi-source BFS to find the distance of every cell to the nearest thief
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q[tail++] = i * n + j;
                    dist[i][j] = 0;
                }
            }
        }
        
        while (head < tail) {
            int curr = q[head++];
            int r = curr / n;
            int c = curr % n;
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q[tail++] = nr * n + nc;
                }
            }
        }
        
        // Binary search the max possible safeness factor
        int left = 0;
        int right = Math.min(dist[0][0], dist[n - 1][n - 1]);
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(dist, n, mid)) {
                ans = mid;
                left = mid + 1; // Try for a larger safeness factor
            } else {
                right = mid - 1; // Safeness factor is too large, reduce it
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int[][] dist, int n, int minSafe) {
        if (dist[0][0] < minSafe) {
            return false;
        }
        
        boolean[][] visited = new boolean[n][n];
        int[] q = new int[n * n];
        int head = 0, tail = 0;
        
        q[tail++] = 0; // Starts at 0 * n + 0
        visited[0][0] = true;
        
        while (head < tail) {
            int curr = q[head++];
            int r = curr / n;
            int c = curr % n;
            
            if (r == n - 1 && c == n - 1) {
                return true;
            }
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                // Added proper bounds checks for both rows and columns
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && dist[nr][nc] >= minSafe) {
                    visited[nr][nc] = true;
                    q[tail++] = nr * n + nc;
                }
            }
        }
        return false;
    }
}

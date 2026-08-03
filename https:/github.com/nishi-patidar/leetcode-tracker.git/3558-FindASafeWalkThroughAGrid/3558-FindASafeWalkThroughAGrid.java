// Last updated: 8/3/2026, 12:46:14 PM
import java.util.List;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        if (grid.get(0).get(0) >= health) {
            return false;
        }
        
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int[] deque = new int[20000];
        int head = 10000;
        int tail = 10000;
        
        dist[0][0] = grid.get(0).get(0);
        deque[tail++] = 0;
        
        int[] dirs = {-1, 0, 1, 0, -1};
        
        while (head < tail) {
            int curr = deque[head++];
            int r = curr / n;
            int c = curr % n;
            int d = dist[r][c];
            
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i];
                int nc = c + dirs[i + 1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = grid.get(nr).get(nc);
                    int nd = d + weight;
                    
                    if (nd < health && nd < dist[nr][nc]) {
                        dist[nr][nc] = nd;
                        if (weight == 0) {
                            deque[--head] = nr * n + nc;
                        } else {
                            deque[tail++] = nr * n + nc;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}

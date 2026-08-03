// Last updated: 8/3/2026, 12:47:54 PM
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        int[][][] dirs = {
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
        };
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            
            int currentStreet = grid[r][c] - 1;
            
            for (int[] d : dirs[currentStreet]) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    boolean connected = false;
                    int nextStreet = grid[nr][nc] - 1;
                    
                    for (int[] backDir : dirs[nextStreet]) {
                        if (nr + backDir[0] == r && nc + backDir[1] == c) {
                            connected = true;
                            break;
                        }
                    }
                    
                    if (connected) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return false;
    }
}

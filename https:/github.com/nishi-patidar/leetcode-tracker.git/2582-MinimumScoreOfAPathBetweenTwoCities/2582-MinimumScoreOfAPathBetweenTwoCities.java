// Last updated: 8/3/2026, 12:46:58 PM
class Solution {
    public int minScore(int n, int[][] roads) {
        int[] root = new int[n + 1];
        int[] min = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            root[i] = i;
            min[i] = 100000;
        }
        
        for (int[] r : roads) {
            int x = find(root, r[0]);
            int y = find(root, r[1]);
            
            if (x != y) {
                root[y] = x;
                if (min[y] < min[x]) {
                    min[x] = min[y];
                }
                if (r[2] < min[x]) {
                    min[x] = r[2];
                }
            } else {
                if (r[2] < min[x]) {
                    min[x] = r[2];
                }
            }
        }
        
        return min[find(root, 1)];
    }
    
    private int find(int[] root, int i) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}

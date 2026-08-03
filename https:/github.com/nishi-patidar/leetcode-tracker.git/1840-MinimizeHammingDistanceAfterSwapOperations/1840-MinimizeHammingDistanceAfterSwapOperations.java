// Last updated: 8/3/2026, 12:47:36 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] swap : allowedSwaps) {
            union(parent, swap[0], swap[1]);
        }
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            map.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> store = map.get(root);
            store.put(source[i], store.getOrDefault(source[i], 0) + 1);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> store = map.get(root);
            
            if (store.getOrDefault(target[i], 0) > 0) {
                store.put(target[i], store.get(target[i]) - 1);
            } else {
                res++;
            }
        }
        
        return res;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
    
    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}

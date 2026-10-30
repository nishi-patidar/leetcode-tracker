// Last updated: 10/30/2026, 8:36:55 PM
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) return 0;
        
        // Custom adjacency list for performance
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[edges.length];
        int[] weight = new int[edges.length];
        int[] next = new int[edges.length];
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            to[i] = v;
            weight[i] = w;
            next[i] = head[u];
            head[u] = i;
        }
        
        // dist[u][count]
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // Priority Queue with bit-manipulation to avoid Object overhead
        // Pack: bits 0-5 for 'count' (max 50), bits 6-21 for 'u' (max 50000), bits 22-63 for 'distance'
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        dist[0][1] = 0;
        pq.offer((0L << 22) | (0L << 6) | 1L);
        
        char[] L = labels.toCharArray();
        
        while (!pq.isEmpty()) {
            long curr = pq.poll();
            int d = (int) (curr >>> 22);
            int u = (int) ((curr >>> 6) & 0xFFFF);
            int count = (int) (curr & 0x3F);
            
            if (d > dist[u][count]) {
                continue;
            }
            if (u == n - 1) {
                return d;
            }
            
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                int w = weight[e];
                
                int nextCount = (L[u] == L[v]) ? count + 1 : 1;
                
                if (nextCount <= k) {
                    if (d + w < dist[v][nextCount]) {
                        dist[v][nextCount] = d + w;
                        pq.offer(((long) (d + w) << 22) | ((long) v << 6) | (long) nextCount);
                    }
                }
            }
        }
        
        return -1;
    }
}
// Last updated: 8/3/2026, 12:45:22 PM
import java.util.Arrays;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int m = edges.length;
        
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[m];
        int[] next = new int[m];
        int[] weight = new int[m];
        int[] inDegree = new int[n];
        
        int maxCost = 0;
        
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            to[i] = v;
            weight[i] = w;
            next[i] = head[u];
            head[u] = i;
            
            inDegree[v]++;
            if (w > maxCost) {
                maxCost = w;
            }
        }
        
        int[] topo = new int[n];
        int[] q = new int[n];
        int qHead = 0, qTail = 0;
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q[qTail++] = i;
            }
        }
        
        while (qHead < qTail) {
            int u = q[qHead++];
            topo[idx++] = u;
            
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q[qTail++] = v;
                }
            }
        }
        
        int low = 0;
        int high = maxCost;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(mid, n, topo, head, to, next, weight, online, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int minEdgeCost, int n, int[] topo, int[] head, int[] to, int[] next, int[] weight, boolean[] online, long k) {
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int u = topo[i];
            
            if (dp[u] == Long.MAX_VALUE || !online[u]) {
                continue;
            }
            
            for (int e = head[u]; e != -1; e = next[e]) {
                if (weight[e] >= minEdgeCost) {
                    int v = to[e];
                    if (dp[u] + weight[e] < dp[v]) {
                        dp[v] = dp[u] + weight[e];
                    }
                }
            }
        }
        
        return dp[n - 1] <= k;
    }
}

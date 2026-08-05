// Last updated: 8/5/2026, 7:29:02 PM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int m = invocations.length;
        int[] next = new int[m];
        int[] to = new int[m];
        
        for (int i = 0; i < m; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];
            to[i] = v;
            next[i] = head[u];
            head[u] = i;
        }
        
        boolean[] suspicious = new boolean[n];
        int[] q = new int[n];
        int qHead = 0;
        int qTail = 0;
        
        q[qTail++] = k;
        suspicious[k] = true;
        
        while (qHead < qTail) {
            int u = q[qHead++];
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    q[qTail++] = v;
                }
            }
        }
        
        boolean canRemove = true;
        for (int i = 0; i < m; i++) {
            if (!suspicious[invocations[i][0]] && suspicious[invocations[i][1]]) {
                canRemove = false;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!canRemove || !suspicious[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}
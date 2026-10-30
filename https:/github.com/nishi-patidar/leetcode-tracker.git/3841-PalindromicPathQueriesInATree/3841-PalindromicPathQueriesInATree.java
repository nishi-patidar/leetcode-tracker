// Last updated: 10/30/2026, 8:36:33 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    int timer;
    int[] tin, tout;
    int[][] up;
    int[] bit;
    char[] chars;
    List<Integer>[] adj;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        this.timer = 0;
        this.tin = new int[n];
        this.tout = new int[n];
        this.up = new int[n][17];
        this.bit = new int[n + 2];
        this.chars = s.toCharArray();
        this.adj = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        dfs(0, 0, 0);
        
        List<Boolean> ans = new ArrayList<>();
        
        for (String q : queries) {
            if (q.charAt(0) == 'u') {
                int firstSpace = q.indexOf(' ');
                int secondSpace = q.indexOf(' ', firstSpace + 1);
                int u = Integer.parseInt(q.substring(firstSpace + 1, secondSpace));
                char c = q.charAt(secondSpace + 1);
                
                int diff = (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'));
                chars[u] = c;
                
                add(tin[u], diff);
                add(tout[u] + 1, diff);
            } else {
                int firstSpace = q.indexOf(' ');
                int secondSpace = q.indexOf(' ', firstSpace + 1);
                int u = Integer.parseInt(q.substring(firstSpace + 1, secondSpace));
                int v = Integer.parseInt(q.substring(secondSpace + 1));
                
                int maskU = query(tin[u]);
                int maskV = query(tin[v]);
                int lcaNode = getLca(u, v);
                int charLca = 1 << (chars[lcaNode] - 'a');
                
                int pathMask = maskU ^ maskV ^ charLca;
                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }
        
        return ans;
    }

    private void dfs(int u, int p, int currentMask) {
        tin[u] = ++timer;
        up[u][0] = p;
        for (int i = 1; i < 17; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }
        
        currentMask ^= (1 << (chars[u] - 'a'));
        add(tin[u], currentMask);
        add(tin[u] + 1, currentMask);
        
        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, currentMask);
            }
        }
        tout[u] = timer;
    }

    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    private int getLca(int u, int v) {
        if (isAncestor(u, v)) return u;
        if (isAncestor(v, u)) return v;
        for (int i = 16; i >= 0; i--) {
            if (!isAncestor(up[u][i], v)) {
                u = up[u][i];
            }
        }
        return up[u][0];
    }

    private void add(int idx, int val) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    private int query(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum ^= bit[idx];
        }
        return sum;
    }
}
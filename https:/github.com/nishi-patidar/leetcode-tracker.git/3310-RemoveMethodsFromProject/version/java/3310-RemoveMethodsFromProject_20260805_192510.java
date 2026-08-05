// Last updated: 8/5/2026, 7:25:10 PM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
7        int[] head = new int[n];
8        Arrays.fill(head, -1);
9        int m = invocations.length;
10        int[] next = new int[m];
11        int[] to = new int[m];
12        
13        for (int i = 0; i < m; i++) {
14            int u = invocations[i][0];
15            int v = invocations[i][1];
16            to[i] = v;
17            next[i] = head[u];
18            head[u] = i;
19        }
20        
21        boolean[] suspicious = new boolean[n];
22        int[] q = new int[n];
23        int qHead = 0;
24        int qTail = 0;
25        
26        q[qTail++] = k;
27        suspicious[k] = true;
28        
29        while (qHead < qTail) {
30            int u = q[qHead++];
31            for (int e = head[u]; e != -1; e = next[e]) {
32                int v = to[e];
33                if (!suspicious[v]) {
34                    suspicious[v] = true;
35                    q[qTail++] = v;
36                }
37            }
38        }
39        
40        boolean canRemove = true;
41        for (int i = 0; i < m; i++) {
42            if (!suspicious[invocations[i][0]] && suspicious[invocations[i][1]]) {
43                canRemove = false;
44                break;
45            }
46        }
47        
48        List<Integer> result = new ArrayList<>();
49        for (int i = 0; i < n; i++) {
50            if (!canRemove || !suspicious[i]) {
51                result.add(i);
52            }
53        }
54        
55        return result;
56    }
57}
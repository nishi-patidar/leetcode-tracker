// Last updated: 8/7/2026, 7:49:30 PM
1class Solution {
2    public String smallestNumber(String num, long t) {
3        long temp = t;
4        int total_a = 0, total_b = 0, total_c = 0, total_d = 0;
5        
6        while (temp % 2 == 0) { total_a++; temp /= 2; }
7        while (temp % 3 == 0) { total_b++; temp /= 3; }
8        while (temp % 5 == 0) { total_c++; temp /= 5; }
9        while (temp % 7 == 0) { total_d++; temp /= 7; }
10        
11        if (temp > 1) {
12            return "-1";
13        }
14        
15        int[][] dp = new int[60][40];
16        for (int i = 0; i < 60; i++) {
17            java.util.Arrays.fill(dp[i], 1000000);
18        }
19        dp[0][0] = 0;
20        
21        for (int i = 0; i < 60; i++) {
22            for (int j = 0; j < 40; j++) {
23                if (i == 0 && j == 0) continue;
24                int res = 1000000;
25                res = Math.min(res, 1 + dp[Math.max(0, i - 1)][j]); 
26                res = Math.min(res, 1 + dp[i][Math.max(0, j - 1)]); 
27                res = Math.min(res, 1 + dp[Math.max(0, i - 2)][j]); 
28                res = Math.min(res, 1 + dp[Math.max(0, i - 1)][Math.max(0, j - 1)]); 
29                res = Math.min(res, 1 + dp[Math.max(0, i - 3)][j]); 
30                res = Math.min(res, 1 + dp[i][Math.max(0, j - 2)]); 
31                dp[i][j] = res;
32            }
33        }
34        
35        int[] p2 = {0,0,1,0,2,0,1,0,3,0};
36        int[] p3 = {0,0,0,1,0,0,1,0,0,2};
37        int[] p5 = {0,0,0,0,0,1,0,0,0,0};
38        int[] p7 = {0,0,0,0,0,0,0,1,0,0};
39        
40        int n = num.length();
41        int[] pref_a = new int[n + 1];
42        int[] pref_b = new int[n + 1];
43        int[] pref_c = new int[n + 1];
44        int[] pref_d = new int[n + 1];
45        
46        for (int i = 0; i < n; i++) {
47            int v = num.charAt(i) - '0';
48            pref_a[i+1] = pref_a[i] + p2[v];
49            pref_b[i+1] = pref_b[i] + p3[v];
50            pref_c[i+1] = pref_c[i] + p5[v];
51            pref_d[i+1] = pref_d[i] + p7[v];
52        }
53        
54        int z = num.indexOf('0');
55        if (z == -1) {
56            if (pref_a[n] >= total_a && pref_b[n] >= total_b && 
57                pref_c[n] >= total_c && pref_d[n] >= total_d) {
58                return num;
59            }
60            z = n;
61        }
62        
63        int best_i = -1;
64        int best_d = -1;
65        
66        for (int i = Math.min(n - 1, z); i >= 0; i--) {
67            int cur_v = num.charAt(i) - '0';
68            int start_d = cur_v + 1;
69            
70            for (int d = start_d; d <= 9; d++) {
71                int req_a = Math.max(0, total_a - pref_a[i]);
72                int req_b = Math.max(0, total_b - pref_b[i]);
73                int req_c = Math.max(0, total_c - pref_c[i]);
74                int req_d = Math.max(0, total_d - pref_d[i]);
75                
76                req_a = Math.max(0, req_a - p2[d]);
77                req_b = Math.max(0, req_b - p3[d]);
78                req_c = Math.max(0, req_c - p5[d]);
79                req_d = Math.max(0, req_d - p7[d]);
80                
81                int rem_len = n - 1 - i;
82                int min_req = req_c + req_d + dp[req_a][req_b];
83                
84                if (min_req <= rem_len) {
85                    best_i = i;
86                    best_d = d;
87                    break;
88                }
89            }
90            if (best_i != -1) break;
91        }
92        
93        if (best_i != -1) {
94            StringBuilder sb = new StringBuilder();
95            sb.append(num.substring(0, best_i));
96            sb.append(best_d);
97            
98            int req_a = Math.max(0, total_a - pref_a[best_i]);
99            int req_b = Math.max(0, total_b - pref_b[best_i]);
100            int req_c = Math.max(0, total_c - pref_c[best_i]);
101            int req_d = Math.max(0, total_d - pref_d[best_i]);
102            
103            req_a = Math.max(0, req_a - p2[best_d]);
104            req_b = Math.max(0, req_b - p3[best_d]);
105            req_c = Math.max(0, req_c - p5[best_d]);
106            req_d = Math.max(0, req_d - p7[best_d]);
107            
108            int rem_len = n - 1 - best_i;
109            
110            for (int pos = 0; pos < rem_len; pos++) {
111                for (int v = 1; v <= 9; v++) {
112                    int n_a = Math.max(0, req_a - p2[v]);
113                    int n_b = Math.max(0, req_b - p3[v]);
114                    int n_c = Math.max(0, req_c - p5[v]);
115                    int n_d = Math.max(0, req_d - p7[v]);
116                    
117                    if (n_c + n_d + dp[n_a][n_b] <= rem_len - 1 - pos) {
118                        sb.append(v);
119                        req_a = n_a;
120                        req_b = n_b;
121                        req_c = n_c;
122                        req_d = n_d;
123                        break;
124                    }
125                }
126            }
127            return sb.toString();
128        }
129        
130        int req_len = Math.max(n + 1, total_c + total_d + dp[total_a][total_b]);
131        StringBuilder sb = new StringBuilder();
132        int req_a = total_a;
133        int req_b = total_b;
134        int req_c = total_c;
135        int req_d = total_d;
136        
137        for (int pos = 0; pos < req_len; pos++) {
138            for (int v = 1; v <= 9; v++) {
139                int n_a = Math.max(0, req_a - p2[v]);
140                int n_b = Math.max(0, req_b - p3[v]);
141                int n_c = Math.max(0, req_c - p5[v]);
142                int n_d = Math.max(0, req_d - p7[v]);
143                
144                if (n_c + n_d + dp[n_a][n_b] <= req_len - 1 - pos) {
145                    sb.append(v);
146                    req_a = n_a;
147                    req_b = n_b;
148                    req_c = n_c;
149                    req_d = n_d;
150                    break;
151                }
152            }
153        }
154        return sb.toString();
155    }
156}
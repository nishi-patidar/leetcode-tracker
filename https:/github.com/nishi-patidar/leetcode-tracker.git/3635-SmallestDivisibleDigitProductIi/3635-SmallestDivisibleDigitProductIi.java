// Last updated: 8/7/2026, 7:50:40 PM
class Solution {
    public String smallestNumber(String num, long t) {
        long temp = t;
        int total_a = 0, total_b = 0, total_c = 0, total_d = 0;
        
        while (temp % 2 == 0) { total_a++; temp /= 2; }
        while (temp % 3 == 0) { total_b++; temp /= 3; }
        while (temp % 5 == 0) { total_c++; temp /= 5; }
        while (temp % 7 == 0) { total_d++; temp /= 7; }
        
        if (temp > 1) {
            return "-1";
        }
        
        int[][] dp = new int[60][40];
        for (int i = 0; i < 60; i++) {
            java.util.Arrays.fill(dp[i], 1000000);
        }
        dp[0][0] = 0;
        
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 40; j++) {
                if (i == 0 && j == 0) continue;
                int res = 1000000;
                res = Math.min(res, 1 + dp[Math.max(0, i - 1)][j]); 
                res = Math.min(res, 1 + dp[i][Math.max(0, j - 1)]); 
                res = Math.min(res, 1 + dp[Math.max(0, i - 2)][j]); 
                res = Math.min(res, 1 + dp[Math.max(0, i - 1)][Math.max(0, j - 1)]); 
                res = Math.min(res, 1 + dp[Math.max(0, i - 3)][j]); 
                res = Math.min(res, 1 + dp[i][Math.max(0, j - 2)]); 
                dp[i][j] = res;
            }
        }
        
        int[] p2 = {0,0,1,0,2,0,1,0,3,0};
        int[] p3 = {0,0,0,1,0,0,1,0,0,2};
        int[] p5 = {0,0,0,0,0,1,0,0,0,0};
        int[] p7 = {0,0,0,0,0,0,0,1,0,0};
        
        int n = num.length();
        int[] pref_a = new int[n + 1];
        int[] pref_b = new int[n + 1];
        int[] pref_c = new int[n + 1];
        int[] pref_d = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            int v = num.charAt(i) - '0';
            pref_a[i+1] = pref_a[i] + p2[v];
            pref_b[i+1] = pref_b[i] + p3[v];
            pref_c[i+1] = pref_c[i] + p5[v];
            pref_d[i+1] = pref_d[i] + p7[v];
        }
        
        int z = num.indexOf('0');
        if (z == -1) {
            if (pref_a[n] >= total_a && pref_b[n] >= total_b && 
                pref_c[n] >= total_c && pref_d[n] >= total_d) {
                return num;
            }
            z = n;
        }
        
        int best_i = -1;
        int best_d = -1;
        
        for (int i = Math.min(n - 1, z); i >= 0; i--) {
            int cur_v = num.charAt(i) - '0';
            int start_d = cur_v + 1;
            
            for (int d = start_d; d <= 9; d++) {
                int req_a = Math.max(0, total_a - pref_a[i]);
                int req_b = Math.max(0, total_b - pref_b[i]);
                int req_c = Math.max(0, total_c - pref_c[i]);
                int req_d = Math.max(0, total_d - pref_d[i]);
                
                req_a = Math.max(0, req_a - p2[d]);
                req_b = Math.max(0, req_b - p3[d]);
                req_c = Math.max(0, req_c - p5[d]);
                req_d = Math.max(0, req_d - p7[d]);
                
                int rem_len = n - 1 - i;
                int min_req = req_c + req_d + dp[req_a][req_b];
                
                if (min_req <= rem_len) {
                    best_i = i;
                    best_d = d;
                    break;
                }
            }
            if (best_i != -1) break;
        }
        
        if (best_i != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(num.substring(0, best_i));
            sb.append(best_d);
            
            int req_a = Math.max(0, total_a - pref_a[best_i]);
            int req_b = Math.max(0, total_b - pref_b[best_i]);
            int req_c = Math.max(0, total_c - pref_c[best_i]);
            int req_d = Math.max(0, total_d - pref_d[best_i]);
            
            req_a = Math.max(0, req_a - p2[best_d]);
            req_b = Math.max(0, req_b - p3[best_d]);
            req_c = Math.max(0, req_c - p5[best_d]);
            req_d = Math.max(0, req_d - p7[best_d]);
            
            int rem_len = n - 1 - best_i;
            
            for (int pos = 0; pos < rem_len; pos++) {
                for (int v = 1; v <= 9; v++) {
                    int n_a = Math.max(0, req_a - p2[v]);
                    int n_b = Math.max(0, req_b - p3[v]);
                    int n_c = Math.max(0, req_c - p5[v]);
                    int n_d = Math.max(0, req_d - p7[v]);
                    
                    if (n_c + n_d + dp[n_a][n_b] <= rem_len - 1 - pos) {
                        sb.append(v);
                        req_a = n_a;
                        req_b = n_b;
                        req_c = n_c;
                        req_d = n_d;
                        break;
                    }
                }
            }
            return sb.toString();
        }
        
        int req_len = Math.max(n + 1, total_c + total_d + dp[total_a][total_b]);
        StringBuilder sb = new StringBuilder();
        int req_a = total_a;
        int req_b = total_b;
        int req_c = total_c;
        int req_d = total_d;
        
        for (int pos = 0; pos < req_len; pos++) {
            for (int v = 1; v <= 9; v++) {
                int n_a = Math.max(0, req_a - p2[v]);
                int n_b = Math.max(0, req_b - p3[v]);
                int n_c = Math.max(0, req_c - p5[v]);
                int n_d = Math.max(0, req_d - p7[v]);
                
                if (n_c + n_d + dp[n_a][n_b] <= req_len - 1 - pos) {
                    sb.append(v);
                    req_a = n_a;
                    req_b = n_b;
                    req_c = n_c;
                    req_d = n_d;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
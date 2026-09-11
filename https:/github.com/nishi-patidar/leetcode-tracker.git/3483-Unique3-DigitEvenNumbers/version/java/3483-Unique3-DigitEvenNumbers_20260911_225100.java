// Last updated: 9/11/2026, 10:51:00 PM
1class Solution {
2    public int totalNumbers(int[] digits) {
3        int[] count = new int[10];
4        for (int d : digits) {
5            count[d]++;
6        }
7        
8        int res = 0;
9        for (int i = 100; i <= 998; i += 2) {
10            int a = i / 100;
11            int b = (i / 10) % 10;
12            int c = i % 10;
13            
14            count[a]--;
15            count[b]--;
16            count[c]--;
17            
18            if (count[a] >= 0 && count[b] >= 0 && count[c] >= 0) {
19                res++;
20            }
21            
22            count[a]++;
23            count[b]++;
24            count[c]++;
25        }
26        
27        return res;
28    }
29}
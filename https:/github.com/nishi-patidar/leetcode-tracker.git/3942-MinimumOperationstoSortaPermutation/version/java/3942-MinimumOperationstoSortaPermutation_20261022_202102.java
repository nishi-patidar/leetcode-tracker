// Last updated: 10/22/2026, 8:21:02 PM
1class Solution {
2    public int minOperations(int[] nums) {
3        int n = nums.length;
4        if (n == 1) {
5            return 0;
6        }
7        
8        int pos0 = -1;
9        for (int i = 0; i < n; i++) {
10            if (nums[i] == 0) {
11                pos0 = i;
12                break;
13            }
14        }
15        
16        boolean isAsc = true;
17        for (int i = 0; i < n; i++) {
18            if (nums[(pos0 + i) % n] != i) {
19                isAsc = false;
20                break;
21            }
22        }
23        
24        boolean isDesc = true;
25        for (int i = 0; i < n; i++) {
26            if (nums[(pos0 - i + n) % n] != i) {
27                isDesc = false;
28                break;
29            }
30        }
31        
32        if (!isAsc && !isDesc) {
33            return -1;
34        }
35        
36        int ans = Integer.MAX_VALUE;
37        
38        if (isAsc) {
39            ans = Math.min(ans, pos0);
40            ans = Math.min(ans, n - pos0 + 2);
41        }
42        
43        if (isDesc) {
44            ans = Math.min(ans, pos0 + 2);
45            ans = Math.min(ans, n - pos0);
46        }
47        
48        return ans;
49    }
50}
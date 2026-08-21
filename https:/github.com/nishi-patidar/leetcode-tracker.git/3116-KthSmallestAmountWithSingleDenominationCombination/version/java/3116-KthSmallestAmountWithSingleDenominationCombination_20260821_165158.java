// Last updated: 8/21/2026, 4:51:58 PM
1class Solution {
2    public long findKthSmallest(int[] coins, int k) {
3        int n = coins.length;
4        long[] lcms = new long[1 << n];
5        int[] bits = new int[1 << n];
6        lcms[0] = 1;
7        
8        long maxVal = 50000000000L; 
9        
10        for (int i = 1; i < (1 << n); i++) {
11            int lastBit = Integer.numberOfTrailingZeros(i);
12            int prevMask = i ^ (1 << lastBit);
13            bits[i] = bits[prevMask] + 1;
14            
15            if (lcms[prevMask] == -1) {
16                lcms[i] = -1;
17            } else {
18                long currentCoin = coins[lastBit];
19                long prevLcm = lcms[prevMask];
20                long g = gcd(currentCoin, prevLcm);
21                
22                if (prevLcm / g > maxVal / currentCoin) {
23                    lcms[i] = -1; 
24                } else {
25                    lcms[i] = (prevLcm / g) * currentCoin;
26                }
27            }
28        }
29        
30        long left = 1;
31        long right = maxVal; 
32        long ans = right;
33        
34        while (left <= right) {
35            long mid = left + (right - left) / 2;
36            if (count(mid, lcms, bits, n) >= k) {
37                ans = mid;
38                right = mid - 1;
39            } else {
40                left = mid + 1;
41            }
42        }
43        
44        return ans;
45    }
46    
47    private long count(long x, long[] lcms, int[] bits, int n) {
48        long count = 0;
49        for (int i = 1; i < (1 << n); i++) {
50            if (lcms[i] != -1) {
51                if (bits[i] % 2 == 1) {
52                    count += x / lcms[i];
53                } else {
54                    count -= x / lcms[i];
55                }
56            }
57        }
58        return count;
59    }
60    
61    private long gcd(long a, long b) {
62        while (b != 0) {
63            long temp = b;
64            b = a % b;
65            a = temp;
66        }
67        return a;
68    }
69}
// Last updated: 9/21/2026, 1:25:32 PM
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3        long[] result = new long[k];
4        long[] prevFreq = new long[k];
5        long[] currFreq = new long[k];
6        
7        for (int num : nums) {
8            int val = num % k;
9            
10            for (int i = 0; i < k; i++) {
11                currFreq[i] = 0;
12            }
13            
14            currFreq[val]++;
15            
16            for (int i = 0; i < k; i++) {
17                if (prevFreq[i] > 0) {
18                    currFreq[(i * val) % k] += prevFreq[i];
19                }
20            }
21            
22            for (int i = 0; i < k; i++) {
23                result[i] += currFreq[i];
24                prevFreq[i] = currFreq[i];
25            }
26        }
27        
28        return result;
29    }
30}
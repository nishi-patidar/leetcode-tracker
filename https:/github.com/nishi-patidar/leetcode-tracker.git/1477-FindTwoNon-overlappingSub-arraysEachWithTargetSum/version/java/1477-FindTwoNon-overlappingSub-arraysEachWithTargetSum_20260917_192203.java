// Last updated: 9/17/2026, 7:22:03 PM
1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4        int[] minLen = new int[n];
5        int sum = 0;
6        int left = 0;
7        int ans = Integer.MAX_VALUE;
8        int currentMinLen = Integer.MAX_VALUE;
9        
10        for (int right = 0; right < n; right++) {
11            sum += arr[right];
12            
13            while (sum > target) {
14                sum -= arr[left];
15                left++;
16            }
17            
18            if (sum == target) {
19                int len = right - left + 1;
20                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
21                    if (len + minLen[left - 1] < ans) {
22                        ans = len + minLen[left - 1];
23                    }
24                }
25                if (len < currentMinLen) {
26                    currentMinLen = len;
27                }
28            }
29            
30            minLen[right] = currentMinLen;
31        }
32        
33        return ans == Integer.MAX_VALUE ? -1 : ans;
34    }
35}
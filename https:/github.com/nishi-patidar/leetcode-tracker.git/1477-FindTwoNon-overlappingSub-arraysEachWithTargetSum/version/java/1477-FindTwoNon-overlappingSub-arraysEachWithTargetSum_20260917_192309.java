// Last updated: 9/17/2026, 7:23:09 PM
1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4        int[] best = new int[n];
5        int sum = 0;
6        int left = 0;
7        int ans = 2147483647;
8        int minLen = 2147483647;
9        
10        for (int right = 0; right < n; right++) {
11            sum += arr[right];
12            
13            while (sum > target) {
14                sum -= arr[left++];
15            }
16            
17            if (sum == target) {
18                int len = right - left + 1;
19                
20                if (left > 0 && best[left - 1] != 2147483647) {
21                    int total = len + best[left - 1];
22                    if (total < ans) {
23                        ans = total;
24                    }
25                }
26                
27                if (len < minLen) {
28                    minLen = len;
29                }
30            }
31            best[right] = minLen;
32        }
33        
34        return ans == 2147483647 ? -1 : ans;
35    }
36}
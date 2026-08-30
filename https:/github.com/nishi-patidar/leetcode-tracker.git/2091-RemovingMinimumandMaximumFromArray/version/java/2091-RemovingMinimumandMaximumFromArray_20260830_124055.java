// Last updated: 8/30/2026, 12:40:55 PM
1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int n = nums.length;
4        if (n <= 2) {
5            return n;
6        }
7
8        int minIdx = 0;
9        int maxIdx = 0;
10        int minVal = nums[0];
11        int maxVal = nums[0];
12        
13        for (int i = 1; i < n; i++) {
14            int val = nums[i];
15            if (val < minVal) {
16                minVal = val;
17                minIdx = i;
18            } else if (val > maxVal) {
19                maxVal = val;
20                maxIdx = i;
21            }
22        }
23        
24        int i, j;
25        if (minIdx < maxIdx) {
26            i = minIdx;
27            j = maxIdx;
28        } else {
29            i = maxIdx;
30            j = minIdx;
31        }
32        
33        int front = j + 1;
34        int back = n - i;
35        int both = i + 1 + n - j;
36        
37        int res = front < back ? front : back;
38        return res < both ? res : both;
39    }
40}
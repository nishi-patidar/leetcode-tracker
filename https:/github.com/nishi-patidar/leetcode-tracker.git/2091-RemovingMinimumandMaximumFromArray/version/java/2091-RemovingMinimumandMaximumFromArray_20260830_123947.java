// Last updated: 8/30/2026, 12:39:47 PM
1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int n = nums.length;
4        if (n <= 2) {
5            return n;
6        }
7
8        int minIdx = 0;
9        int maxIdx = 0;
10        
11        for (int i = 1; i < n; i++) {
12            if (nums[i] < nums[minIdx]) {
13                minIdx = i;
14            }
15            if (nums[i] > nums[maxIdx]) {
16                maxIdx = i;
17            }
18        }
19        
20        int first = minIdx < maxIdx ? minIdx : maxIdx;
21        int second = minIdx > maxIdx ? minIdx : maxIdx;
22        
23        int front = second + 1;
24        int back = n - first;
25        int both = first + 1 + n - second;
26        
27        int res = front < back ? front : back;
28        return res < both ? res : both;
29    }
30}
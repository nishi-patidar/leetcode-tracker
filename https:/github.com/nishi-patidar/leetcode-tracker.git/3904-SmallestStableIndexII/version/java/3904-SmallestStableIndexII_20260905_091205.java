// Last updated: 9/5/2026, 9:12:05 AM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] minRight = new int[n];
5        int currentMin = nums[n - 1];
6        minRight[n - 1] = currentMin;
7        
8        for (int i = n - 2; i >= 0; i--) {
9            if (nums[i] < currentMin) {
10                currentMin = nums[i];
11            }
12            minRight[i] = currentMin;
13        }
14        
15        int maxLeft = nums[0];
16        for (int i = 0; i < n; i++) {
17            if (nums[i] > maxLeft) {
18                maxLeft = nums[i];
19            }
20            if (maxLeft - minRight[i] <= k) {
21                return i;
22            }
23        }
24        
25        return -1;
26    }
27}
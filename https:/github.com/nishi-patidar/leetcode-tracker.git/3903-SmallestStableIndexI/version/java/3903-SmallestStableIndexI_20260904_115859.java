// Last updated: 9/4/2026, 11:58:59 AM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] minRight = new int[n];
5        minRight[n - 1] = nums[n - 1];
6        
7        for (int i = n - 2; i >= 0; i--) {
8            minRight[i] = nums[i] < minRight[i + 1] ? nums[i] : minRight[i + 1];
9        }
10        
11        int maxLeft = -1;
12        for (int i = 0; i < n; i++) {
13            if (nums[i] > maxLeft) {
14                maxLeft = nums[i];
15            }
16            if (maxLeft - minRight[i] <= k) {
17                return i;
18            }
19        }
20        
21        return -1;
22    }
23}
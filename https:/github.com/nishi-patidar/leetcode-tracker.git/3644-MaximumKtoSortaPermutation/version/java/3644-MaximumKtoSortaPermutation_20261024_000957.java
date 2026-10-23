// Last updated: 10/24/2026, 12:09:57 AM
1class Solution {
2    public int sortPermutation(int[] nums) {
3        int ans = -1;
4        for (int i = 0; i < nums.length; i++) {
5            if (nums[i] != i) {
6                ans = (ans == -1) ? nums[i] : (ans & nums[i]);
7            }
8        }
9        return ans == -1 ? 0 : ans;
10    }
11}
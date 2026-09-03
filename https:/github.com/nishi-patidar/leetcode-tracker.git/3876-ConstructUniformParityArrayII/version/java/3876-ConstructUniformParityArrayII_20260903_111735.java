// Last updated: 9/3/2026, 11:17:35 AM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int min = Integer.MAX_VALUE;
4        boolean hasOdd = false;
5        
6        for (int x : nums1) {
7            if (x < min) {
8                min = x;
9            }
10            if ((x & 1) == 1) {
11                hasOdd = true;
12            }
13        }
14        
15        return (min & 1) == 1 || !hasOdd;
16    }
17}
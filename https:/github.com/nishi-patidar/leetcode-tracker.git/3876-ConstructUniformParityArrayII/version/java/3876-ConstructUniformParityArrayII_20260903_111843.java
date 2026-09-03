// Last updated: 9/3/2026, 11:18:43 AM
1class Solution {
2    public boolean uniformArray(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        
5        // Pass 1: Find the minimum element
6        for (int num : nums) {
7            if (num < min) {
8                min = num;
9            }
10        }
11        
12        // If the smallest element is odd, it's always possible
13        // to make everything odd (since Even - Odd = Odd)
14        if ((min & 1) == 1) {
15            return true;
16        }
17        
18        // Pass 2: If the minimum is even, we can only make everything even
19        // This is ONLY possible if there are NO odd elements in the array
20        for (int num : nums) {
21            if ((num & 1) == 1) {
22                return false;
23            }
24        }
25        
26        return true;
27    }
28}
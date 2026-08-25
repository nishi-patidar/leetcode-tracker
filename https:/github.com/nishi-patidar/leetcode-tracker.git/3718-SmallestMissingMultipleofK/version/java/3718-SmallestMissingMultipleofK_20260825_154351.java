// Last updated: 8/25/2026, 3:43:51 PM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        boolean[] present = new boolean[101];
4        
5        for (int num : nums) {
6            present[num] = true;
7        }
8        
9        int multiple = k;
10        while (multiple <= 100 && present[multiple]) {
11            multiple += k;
12        }
13        
14        return multiple;
15    }
16}
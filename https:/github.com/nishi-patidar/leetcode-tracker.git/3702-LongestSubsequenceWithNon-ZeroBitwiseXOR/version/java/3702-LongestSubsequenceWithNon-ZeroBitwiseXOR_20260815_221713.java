// Last updated: 8/15/2026, 10:17:13 PM
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int xorSum = 0;
4        boolean hasNonZero = false;
5        
6        for (int num : nums) {
7            xorSum ^= num;
8            if (num != 0) {
9                hasNonZero = true;
10            }
11        }
12        
13        if (!hasNonZero) {
14            return 0;
15        }
16        
17        if (xorSum != 0) {
18            return nums.length;
19        }
20        
21        return nums.length - 1;
22    }
23}
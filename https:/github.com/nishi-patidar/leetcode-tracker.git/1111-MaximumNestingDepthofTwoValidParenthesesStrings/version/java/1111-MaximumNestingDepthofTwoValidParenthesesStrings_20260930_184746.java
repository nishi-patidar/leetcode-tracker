// Last updated: 9/30/2026, 6:47:46 PM
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        char[] arr = seq.toCharArray();
4        int n = arr.length;
5        int[] ans = new int[n];
6        
7        for (int i = 0; i < n; i++) {
8            ans[i] = (i & 1) ^ (arr[i] == ')' ? 1 : 0);
9        }
10        
11        return ans;
12    }
13}
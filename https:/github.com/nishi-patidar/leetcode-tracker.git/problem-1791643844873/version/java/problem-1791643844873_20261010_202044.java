// Last updated: 10/10/2026, 8:20:44 PM
1class Solution {
2    public int resilientSubarray(int[] nums, int k) {
3        int maxLen = 1, i=0, n=nums.length;
4        while(i<n){
5            int r = nums[i] % k, j=i;
6            while (j<n && nums[j] % k == r) j++;
7            int step = k / gcd(r, k);
8            maxLen = Math.max(maxLen, ((j-i-1)/ step)* step +1);
9            i=j;
10        }
11        return maxLen;
12    }
13    private int gcd(int a, int b ){
14        return b ==0 ? a: gcd(b, a%b);
15    }
16}
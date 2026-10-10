// Last updated: 10/10/2026, 8:16:25 PM
1class Solution {
2    public int resilientSubarray(int[] nums, int k) {
3        int maxLen = 1, i=0, n=nums.length;
4        while(i< n){
5            int r = nums[i] % k, j =i;
6            while(j < n && nums[j] % k == r) j++;
7            for(int L = j-i; L> maxLen; L--){
8                if((long)(L-1)*r%k==0){
9                    maxLen = L;
10                    break;
11                }
12            }
13            i=j;
14        }
15        return maxLen;
16    }
17}
// Last updated: 10/20/2026, 9:29:48 PM
class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int maxLen = 1, i=0, n=nums.length;
        while(i< n){
            int r = nums[i] % k, j =i;
            while(j < n && nums[j] % k == r) j++;
            for(int L = j-i; L> maxLen; L--){
                if((long)(L-1)*r%k==0){
                    maxLen = L;
                    break;
                }
            }
            i=j;
        }
        return maxLen;
    }
}
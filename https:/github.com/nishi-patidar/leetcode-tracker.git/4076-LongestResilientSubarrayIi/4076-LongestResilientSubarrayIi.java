// Last updated: 10/20/2026, 9:29:46 PM
class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int maxLen = 1, i=0, n=nums.length;
        while(i<n){
            int r = nums[i] % k, j=i;
            while (j<n && nums[j] % k == r) j++;
            int step = k / gcd(r, k);
            maxLen = Math.max(maxLen, ((j-i-1)/ step)* step +1);
            i=j;
        }
        return maxLen;
    }
    private int gcd(int a, int b ){
        return b ==0 ? a: gcd(b, a%b);
    }
}
// Last updated: 10/30/2026, 8:35:57 PM
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0;
        long currentLength =0;

        for(int num: nums){
            if(num>= minK && num<=maxK){
                currentLength++;
                ans+= currentLength;
            }else{
                currentLength=0;
            }
        }
        
        return ans;
    }
}
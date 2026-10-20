// Last updated: 10/20/2026, 9:29:50 PM
class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int[] ans = {-1, -1};
        long max = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j =0; j<i; j++){
                if(nums[i] +nums[j] == target && nums[i] != nums[j] && (long)nums[i] * nums[j] > max){
                    max = (long)nums[i] *nums[j];
                    ans = nums[i] > nums[j] ? new int[]{i,j} : new int[]{j, i};
                }
            }
        }
        return ans;
    }
}
// Last updated: 10/1/2026, 2:54:15 PM
class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int[] mavontelia = nums;
        int maxI = mavontelia[0];
        int maxSum = 0;
        
        for (int j = k; j < mavontelia.length; j++) {
            maxI = Math.max(maxI, mavontelia[j - k]);
            maxSum = Math.max(maxSum, maxI + mavontelia[j]);
        }
        
        return maxSum;
    }
}
// Last updated: 8/3/2026, 12:46:52 PM
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int totalSum = 0;
        int leftSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        
        return answer;
    }
}

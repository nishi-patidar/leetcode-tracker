// Last updated: 10/1/2026, 2:54:34 PM
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minRight = new int[n];
        int currentMin = nums[n - 1];
        minRight[n - 1] = currentMin;
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < currentMin) {
                currentMin = nums[i];
            }
            minRight[i] = currentMin;
        }
        
        int maxLeft = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxLeft) {
                maxLeft = nums[i];
            }
            if (maxLeft - minRight[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}
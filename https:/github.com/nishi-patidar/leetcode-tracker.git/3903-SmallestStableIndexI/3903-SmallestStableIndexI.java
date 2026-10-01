// Last updated: 10/1/2026, 2:54:36 PM
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = nums[i] < minRight[i + 1] ? nums[i] : minRight[i + 1];
        }
        
        int maxLeft = -1;
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
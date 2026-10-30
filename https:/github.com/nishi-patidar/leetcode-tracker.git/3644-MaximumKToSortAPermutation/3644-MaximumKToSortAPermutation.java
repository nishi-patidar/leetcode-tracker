// Last updated: 10/30/2026, 8:37:15 PM
class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans = (ans == -1) ? nums[i] : (ans & nums[i]);
            }
        }
        return ans == -1 ? 0 : ans;
    }
}
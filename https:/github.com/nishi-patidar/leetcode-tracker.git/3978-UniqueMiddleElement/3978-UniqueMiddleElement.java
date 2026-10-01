// Last updated: 10/1/2026, 2:54:12 PM
class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums.length / 2;
        int target = nums[mid];
        int count = 0;
        
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        
        return count == 1;
    }
}
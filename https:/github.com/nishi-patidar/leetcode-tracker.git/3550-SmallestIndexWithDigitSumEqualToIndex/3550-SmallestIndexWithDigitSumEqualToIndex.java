// Last updated: 10/1/2026, 2:56:44 PM
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = (n % 10) + ((n / 10) % 10) + ((n / 100) % 10) + (n / 1000);
            
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}
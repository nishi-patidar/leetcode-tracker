// Last updated: 8/3/2026, 12:44:50 PM
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int balance = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    balance += 1;
                } else {
                    balance -= 1;
                }
                
                if (balance > 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}

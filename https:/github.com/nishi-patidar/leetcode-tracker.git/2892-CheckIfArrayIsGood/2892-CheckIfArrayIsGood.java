// Last updated: 8/3/2026, 12:46:39 PM
class Solution {
    public boolean isGood(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        
        if (nums.length != max + 1) {
            return false;
        }
        
        int[] count = new int[max + 1];
        for (int num : nums) {
            if (num > max) {
                return false;
            }
            count[num]++;
        }
        
        for (int i = 1; i < max; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        
        return count[max] == 2;
    }
}

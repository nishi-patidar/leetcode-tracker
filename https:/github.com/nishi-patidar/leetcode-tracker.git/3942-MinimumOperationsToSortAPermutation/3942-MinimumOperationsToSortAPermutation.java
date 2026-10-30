// Last updated: 10/30/2026, 8:36:42 PM
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        
        int pos0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }
        
        boolean isAsc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(pos0 + i) % n] != i) {
                isAsc = false;
                break;
            }
        }
        
        boolean isDesc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(pos0 - i + n) % n] != i) {
                isDesc = false;
                break;
            }
        }
        
        if (!isAsc && !isDesc) {
            return -1;
        }
        
        int ans = Integer.MAX_VALUE;
        
        if (isAsc) {
            ans = Math.min(ans, pos0);
            ans = Math.min(ans, n - pos0 + 2);
        }
        
        if (isDesc) {
            ans = Math.min(ans, pos0 + 2);
            ans = Math.min(ans, n - pos0);
        }
        
        return ans;
    }
}
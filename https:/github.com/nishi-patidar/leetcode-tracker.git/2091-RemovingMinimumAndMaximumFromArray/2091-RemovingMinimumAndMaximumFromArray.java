// Last updated: 10/1/2026, 3:00:28 PM
class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int minIdx = 0;
        int maxIdx = 0;
        int minVal = nums[0];
        int maxVal = nums[0];
        
        for (int i = 1; i < n; i++) {
            int val = nums[i];
            if (val < minVal) {
                minVal = val;
                minIdx = i;
            } else if (val > maxVal) {
                maxVal = val;
                maxIdx = i;
            }
        }
        
        int i, j;
        if (minIdx < maxIdx) {
            i = minIdx;
            j = maxIdx;
        } else {
            i = maxIdx;
            j = minIdx;
        }
        
        int front = j + 1;
        int back = n - i;
        int both = i + 1 + n - j;
        
        int res = front < back ? front : back;
        return res < both ? res : both;
    }
}
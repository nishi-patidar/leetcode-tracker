// Last updated: 10/1/2026, 2:55:34 PM
class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];
        
        for (int num : nums) {
            present[num] = true;
        }
        
        int multiple = k;
        while (multiple <= 100 && present[multiple]) {
            multiple += k;
        }
        
        return multiple;
    }
}
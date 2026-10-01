// Last updated: 10/1/2026, 2:54:38 PM
class Solution {
    public boolean uniformArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        // Pass 1: Find the minimum element
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        
        // If the smallest element is odd, it's always possible
        // to make everything odd (since Even - Odd = Odd)
        if ((min & 1) == 1) {
            return true;
        }
        
        // Pass 2: If the minimum is even, we can only make everything even
        // This is ONLY possible if there are NO odd elements in the array
        for (int num : nums) {
            if ((num & 1) == 1) {
                return false;
            }
        }
        
        return true;
    }
}
// Last updated: 8/3/2026, 12:46:08 PM
class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int currentSum = 0;
            
            while (num > 0) {
                currentSum += num % 10;
                num /= 10;
            }
            
            if (currentSum < minSum) {
                minSum = currentSum;
            }
        }
        
        return minSum;
    }
}

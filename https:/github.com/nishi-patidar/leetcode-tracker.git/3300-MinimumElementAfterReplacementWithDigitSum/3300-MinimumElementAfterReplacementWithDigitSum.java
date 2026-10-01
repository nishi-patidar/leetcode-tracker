// Last updated: 10/1/2026, 2:58:06 PM
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

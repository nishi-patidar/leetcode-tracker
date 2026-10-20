// Last updated: 10/20/2026, 9:31:59 PM
class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        // Iterate up to the square root of n to find divisor pairs in O(sqrt(N)) time
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                // Convert 1-based index 'i' to 0-based array index 'i - 1'
                int val1 = nums[i - 1];
                sum += val1 * val1;
                
                // Find the complementary divisor (n / i)
                int pair = n / i;
                
                // Avoid double-counting if n is a perfect square (e.g., i * i == n)
                if (pair != i) {
                    int val2 = nums[pair - 1];
                    sum += val2 * val2;
                }
            }
        }
        
        return sum;
    }
}
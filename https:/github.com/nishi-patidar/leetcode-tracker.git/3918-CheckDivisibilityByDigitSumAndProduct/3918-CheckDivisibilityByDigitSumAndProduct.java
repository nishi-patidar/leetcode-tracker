// Last updated: 8/24/2026, 8:50:06 PM
class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int temp = n;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        
        return n % (sum + product) == 0;
    }
}

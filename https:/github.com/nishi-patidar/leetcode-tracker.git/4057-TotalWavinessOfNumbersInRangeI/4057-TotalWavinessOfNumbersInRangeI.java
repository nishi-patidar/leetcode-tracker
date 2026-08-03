// Last updated: 8/3/2026, 12:44:52 PM
class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int i = num1; i <= num2; i++) {
            total += getWaviness(i);
        }
        return total;
    }
    
    private int getWaviness(int x) {
        int[] digits = new int[10];
        int length = 0;
        
        while (x > 0) {
            digits[length++] = x % 10;
            x /= 10;
        }
        
        if (length < 3) {
            return 0;
        }
        
        int w = 0;
        for (int i = 1; i < length - 1; i++) {
            if ((digits[i] > digits[i - 1] && digits[i] > digits[i + 1]) || 
                (digits[i] < digits[i - 1] && digits[i] < digits[i + 1])) {
                w++;
            }
        }
        
        return w;
    }
}

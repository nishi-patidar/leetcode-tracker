// Last updated: 8/3/2026, 12:49:01 PM
class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        int steps = m + n - 2;
        int r = m < n ? m - 1 : n - 1;
        
        for (int i = 1; i <= r; i++) {
            result = result * (steps - i + 1) / i;
        }
        
        return (int) result;
    }
}

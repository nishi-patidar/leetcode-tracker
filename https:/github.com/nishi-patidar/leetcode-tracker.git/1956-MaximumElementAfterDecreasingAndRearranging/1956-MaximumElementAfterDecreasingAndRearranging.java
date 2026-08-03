// Last updated: 8/3/2026, 12:47:31 PM
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n + 1];
        
        for (int num : arr) {
            counts[Math.min(num, n)]++;
        }
        
        int maxVal = 1;
        for (int i = 2; i <= n; i++) {
            maxVal = Math.min(maxVal + counts[i], i);
        }
        
        return maxVal;
    }
}

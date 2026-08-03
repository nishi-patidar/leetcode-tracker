// Last updated: 8/3/2026, 12:47:12 PM
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDistFromFirst = 0;
        int maxDistFromLast = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDistFromFirst = i;
                break;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDistFromLast = (n - 1) - i;
                break;
            }
        }
        
        return Math.max(maxDistFromFirst, maxDistFromLast);
    }
}

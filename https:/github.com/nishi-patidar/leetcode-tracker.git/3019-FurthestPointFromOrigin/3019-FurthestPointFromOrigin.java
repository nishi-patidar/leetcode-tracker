// Last updated: 8/3/2026, 12:46:34 PM
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0;
        int rCount = 0;
        int underscoreCount = 0;
        
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                lCount++;
            } else if (c == 'R') {
                rCount++;
            } else {
                underscoreCount++;
            }
        }
        
        return Math.abs(lCount - rCount) + underscoreCount;
    }
}

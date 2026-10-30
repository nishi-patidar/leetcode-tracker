// Last updated: 10/30/2026, 8:35:24 PM
class Solution {
    public int calculateScore(int a, int b) {
        int s1 = Integer.bitCount(a);
        int s2 = Integer.bitCount(b);

        return s1>=s2 ? s1*s2 : s2/s1;
    }
}
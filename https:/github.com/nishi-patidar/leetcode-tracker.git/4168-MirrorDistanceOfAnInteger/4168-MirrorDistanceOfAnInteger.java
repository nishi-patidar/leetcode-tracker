// Last updated: 8/3/2026, 12:44:19 PM
class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int reversed = 0;
        int temp = n;

        while (temp > 0) {
            reversed = (reversed * 10) + (temp % 10);
            temp /= 10;
        }

        return Math.abs(original - reversed);
    }
}

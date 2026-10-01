// Last updated: 10/1/2026, 2:55:00 PM
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

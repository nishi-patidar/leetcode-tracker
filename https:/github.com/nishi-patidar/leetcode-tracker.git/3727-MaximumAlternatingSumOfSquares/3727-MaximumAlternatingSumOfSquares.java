// Last updated: 10/20/2026, 9:30:36 PM
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] counts = new int[40001];
        for (int num : nums) {
            counts[num < 0 ? -num : num]++;
        }
        
        int plusCount = (nums.length + 1) / 2;
        long ans = 0;
        
        for (int i = 40000; i >= 0; i--) {
            if (counts[i] > 0) {
                long sq = (long) i * i;
                if (plusCount >= counts[i]) {
                    ans += counts[i] * sq;
                    plusCount -= counts[i];
                } else {
                    int minusCount = counts[i] - plusCount;
                    ans += plusCount * sq;
                    ans -= minusCount * sq;
                    plusCount = 0;
                }
            }
        }
        
        return ans;
    }
}
// Last updated: 10/20/2026, 9:32:12 PM
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] bucket = new int[100001];
        long k = (long) k1 + k2;
        long diffSum = 0;
        int maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            bucket[diff]++;
            diffSum += diff;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        if (diffSum <= k) {
            return 0;
        }
        
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (bucket[i] > 0) {
                long minus = Math.min((long) bucket[i], k);
                bucket[i] -= minus;
                bucket[i - 1] += minus;
                k -= minus;
            }
        }
        
        long ans = 0;
        for (int i = maxDiff; i > 0; i--) {
            if (bucket[i] > 0) {
                ans += (long) bucket[i] * i * i;
            }
        }
        
        return ans;
    }
}
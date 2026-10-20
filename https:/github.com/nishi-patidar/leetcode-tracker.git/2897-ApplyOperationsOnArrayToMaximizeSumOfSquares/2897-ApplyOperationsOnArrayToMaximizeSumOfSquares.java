// Last updated: 10/20/2026, 9:31:45 PM
import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] counts = new int[32];
        
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    counts[i]++;
                }
            }
        }
        
        long result = 0;
        long mod = 1_000_000_007;
        
        for (int i = 0; i < k; i++) {
            long val = 0;
            for (int j = 0; j < 32; j++) {
                if (counts[j] > 0) {
                    val |= (1L << j);
                    counts[j]--;
                }
            }
            result = (result + (val * val) % mod) % mod;
        }
        
        return (int) result;
    }
}

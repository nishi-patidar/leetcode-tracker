// Last updated: 8/24/2026, 8:50:36 PM
class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long[] lcms = new long[1 << n];
        int[] bits = new int[1 << n];
        lcms[0] = 1;
        
        long maxVal = 50000000000L; 
        
        for (int i = 1; i < (1 << n); i++) {
            int lastBit = Integer.numberOfTrailingZeros(i);
            int prevMask = i ^ (1 << lastBit);
            bits[i] = bits[prevMask] + 1;
            
            if (lcms[prevMask] == -1) {
                lcms[i] = -1;
            } else {
                long currentCoin = coins[lastBit];
                long prevLcm = lcms[prevMask];
                long g = gcd(currentCoin, prevLcm);
                
                if (prevLcm / g > maxVal / currentCoin) {
                    lcms[i] = -1; 
                } else {
                    lcms[i] = (prevLcm / g) * currentCoin;
                }
            }
        }
        
        long left = 1;
        long right = maxVal; 
        long ans = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (count(mid, lcms, bits, n) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    private long count(long x, long[] lcms, int[] bits, int n) {
        long count = 0;
        for (int i = 1; i < (1 << n); i++) {
            if (lcms[i] != -1) {
                if (bits[i] % 2 == 1) {
                    count += x / lcms[i];
                } else {
                    count -= x / lcms[i];
                }
            }
        }
        return count;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
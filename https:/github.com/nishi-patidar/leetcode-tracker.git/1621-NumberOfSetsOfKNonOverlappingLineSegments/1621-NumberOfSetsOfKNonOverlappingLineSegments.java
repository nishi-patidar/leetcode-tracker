// Last updated: 10/1/2026, 3:01:40 PM
class Solution {
    public int numberOfSets(int n, int k) {
        int mod = 1000000007;
        int N = n + k - 1;
        int K = 2 * k;
        
        if (K > N) {
            return 0;
        }
        
        long num = 1;
        long den = 1;
        
        for (int i = 1; i <= K; i++) {
            num = (num * (N - i + 1)) % mod;
            den = (den * i) % mod;
        }
        
        return (int) ((num * power(den, mod - 2, mod)) % mod);
    }
    
    private long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
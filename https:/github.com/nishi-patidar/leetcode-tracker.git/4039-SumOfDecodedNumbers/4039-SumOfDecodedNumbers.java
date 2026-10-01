// Last updated: 10/1/2026, 2:53:51 PM
class Solution {
    public int sumDecoded(long[] nums) {
       long mod = 1_000_000_007;
        long total = 0;

        for(long num : nums){
            int width = (int)(num %10);
            String s = Long.toString(num/10);

            long x = Long.parseLong(s.substring(0, width));
            long y = Long.parseLong(s.substring(width));
            total = (total + power(x, y,mod)) % mod;
        }
        return (int) total;
    }
    private long power(long base, long exp, long mod){
        long res =1;
        base %=mod;
        while(exp>0){
            if((exp & 1) ==1) res = (res* base)%mod;
            base = (base * base) % mod;
            exp>>=1;
        }
        return res;
    }
}
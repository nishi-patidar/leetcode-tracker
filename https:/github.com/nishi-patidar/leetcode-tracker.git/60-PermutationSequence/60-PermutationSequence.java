// Last updated: 8/3/2026, 12:49:05 PM
class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        boolean[] used = new boolean[n + 1];
        k--;
        char[] res = new char[n];
        
        for (int i = 0; i < n; i++) {
            int count = k / fact[n - 1 - i];
            for (int j = 1; j <= n; j++) {
                if (!used[j]) {
                    if (count == 0) {
                        used[j] = true;
                        res[i] = (char) (j + '0');
                        break;
                    }
                    count--;
                }
            }
            k %= fact[n - 1 - i];
        }
        
        return new String(res);
    }
}

// Last updated: 10/20/2026, 9:30:16 PM
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        HashMap<Integer, Long> hashMap = new HashMap<>();
        Random rnd = new Random(1234567L);
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, rnd.nextLong());
            }
        }
        
        long[] prefHash = new long[n + 1];
        long[] prefSortedHash = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefHash[i + 1] = prefHash[i] + hashMap.get(nums[i]);
            prefSortedHash[i + 1] = prefSortedHash[i] + hashMap.get(sortedNums[i]);
        }
        
        int[] prefDrop = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int d = nums[i] > nums[i + 1] ? 1 : 0;
            prefDrop[i] = (i > 0 ? prefDrop[i - 1] : 0) + d;
        }
        if (n > 1) {
            prefDrop[n - 1] = prefDrop[n - 2];
        }
        
        int ans = 0;
        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                if (check(k, n, nums, prefHash, prefSortedHash, prefDrop)) {
                    ans += k;
                }
                if (k * k != n) {
                    int other = n / k;
                    if (check(other, n, nums, prefHash, prefSortedHash, prefDrop)) {
                        ans += other;
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean check(int k, int n, int[] nums, long[] prefHash, long[] prefSortedHash, int[] prefDrop) {
        for (int i = 0; i < n; i += k) {
            int L = i;
            int R = i + k - 1;
            
            long h1 = prefHash[R + 1] - prefHash[L];
            long h2 = prefSortedHash[R + 1] - prefSortedHash[L];
            if (h1 != h2) return false;
            
            if (k > 1) {
                int drops = prefDrop[R - 1] - (L > 0 ? prefDrop[L - 1] : 0);
                if (drops > 1) return false;
                if (drops == 1 && nums[R] > nums[L]) return false;
            }
        }
        return true;
    }
}
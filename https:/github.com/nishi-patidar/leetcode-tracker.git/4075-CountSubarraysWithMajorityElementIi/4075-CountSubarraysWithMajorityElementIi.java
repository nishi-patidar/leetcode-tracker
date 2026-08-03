// Last updated: 8/3/2026, 12:44:48 PM
class Solution {
    private int[] bit;
    private int size;

    private void update(int idx, int val) {
        while (idx <= size) {
            bit[idx] += val;
            idx += idx & (-idx);
        }
    }

    private int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & (-idx);
        }
        return sum;
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        size = 2 * n + 1;
        bit = new int[size + 1];
        
        long count = 0;
        int prefixSum = 0;
        
        update(n + 1, 1);
        
        for (int num : nums) {
            if (num == target) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }
            
            count += query(prefixSum + n);
            update(prefixSum + n + 1, 1);
        }
        
        return count;
    }
}

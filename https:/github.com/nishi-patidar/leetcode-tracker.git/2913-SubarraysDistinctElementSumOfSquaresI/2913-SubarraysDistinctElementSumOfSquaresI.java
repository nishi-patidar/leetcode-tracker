// Last updated: 10/20/2026, 9:31:43 PM
import java.util.List;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[101];
            int count = 0;
            for (int j = i; j < n; j++) {
                int val = nums.get(j);
                if (!seen[val]) {
                    seen[val] = true;
                    count++;
                }
                ans += count * count;
            }
        }
        return ans;
    }
}
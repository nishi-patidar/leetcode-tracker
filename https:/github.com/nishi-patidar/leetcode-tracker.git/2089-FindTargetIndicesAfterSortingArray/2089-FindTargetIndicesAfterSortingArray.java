// Last updated: 10/20/2026, 9:32:21 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThan = 0;
        int count = 0;
        
        for (int num : nums) {
            if (num < target) {
                lessThan++;
            } else if (num == target) {
                count++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessThan + i);
        }
        
        return result;
    }
}
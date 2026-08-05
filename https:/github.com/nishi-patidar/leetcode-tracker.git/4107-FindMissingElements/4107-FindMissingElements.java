// Last updated: 8/5/2026, 7:28:23 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = 101;
        int max = 0;
        boolean[] present = new boolean[101];
        
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            present[num] = true;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}
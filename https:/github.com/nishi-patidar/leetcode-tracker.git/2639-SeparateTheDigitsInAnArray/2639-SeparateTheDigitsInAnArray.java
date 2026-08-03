// Last updated: 8/3/2026, 12:46:55 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();
        
        for (int num : nums) {
            String s = String.valueOf(num);
            for (char c : s.toCharArray()) {
                digits.add(c - '0');
            }
        }
        
        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(i);
        }
        
        return result;
    }
}

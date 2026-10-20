// Last updated: 10/20/2026, 9:33:15 PM
class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();
        
        for (char c : arr) {
            if (c == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        
        return left + right;
    }
}
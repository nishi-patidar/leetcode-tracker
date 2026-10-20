// Last updated: 10/20/2026, 9:33:30 PM
class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0;
        int cmax = 0;
        
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                if (cmin > 0) {
                    cmin--;
                }
            } else {
                cmax++;
                if (cmin > 0) {
                    cmin--;
                }
            }
            
            if (cmax < 0) {
                return false;
            }
        }
        
        return cmin == 0;
    }
}
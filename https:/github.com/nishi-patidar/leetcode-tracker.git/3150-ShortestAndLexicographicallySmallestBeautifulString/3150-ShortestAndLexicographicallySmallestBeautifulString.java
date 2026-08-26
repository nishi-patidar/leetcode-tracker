// Last updated: 8/26/2026, 5:07:28 PM
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String best = "";

        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int right = 0; right < n; right++) {
            if (chars[right] == '1') {
                ones++;
            }
            
            while (ones == k) {
                while (chars[left] == '0') {
                    left++;
                }
                
                int len = right - left + 1;
                
                if (len < minLen) {
                    minLen = len;
                    best = s.substring(left, right + 1);
                } else if (len == minLen) {
                    String current = s.substring(left, right + 1);
                    if (current.compareTo(best) < 0) {
                        best = current;
                    }
                }
                
                ones--;
                left++;
            }
        }
        
        return best;
    }
}
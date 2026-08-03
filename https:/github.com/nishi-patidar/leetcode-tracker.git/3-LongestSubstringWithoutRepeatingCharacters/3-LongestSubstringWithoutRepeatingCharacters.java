// Last updated: 8/3/2026, 12:52:15 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
int[] charIndex = new int[128];
        java.util.Arrays.fill(charIndex, -1);
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if (charIndex[c] >= left) {
                left = charIndex[c] + 1;
            }
            
            charIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
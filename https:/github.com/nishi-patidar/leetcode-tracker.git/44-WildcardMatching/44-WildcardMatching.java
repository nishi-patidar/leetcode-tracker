// Last updated: 8/3/2026, 12:49:59 PM
class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int match = 0, starIdx = -1;
        
        while (sIdx < s.length()) {
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            } else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            } else if (starIdx != -1) {
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            } else {
                return false;
            }
        }
        
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == p.length();
    }
}

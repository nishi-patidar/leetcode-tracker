// Last updated: 8/3/2026, 12:50:52 PM
class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            
            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            
            if (j == nLen) {
                return i;
            }
        }
        
        return -1;
    }
}

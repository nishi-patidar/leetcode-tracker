// Last updated: 8/3/2026, 12:47:55 PM
class Solution {
    public int numberOfSubstrings(String s) {
        int a = -1, b = -1, c = -1;
        int count = 0;
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') a = i;
            else if (chars[i] == 'b') b = i;
            else c = i;
            
            int min = a;
            if (b < min) min = b;
            if (c < min) min = c;
            
            count += min + 1;
        }
        
        return count;
    }
}

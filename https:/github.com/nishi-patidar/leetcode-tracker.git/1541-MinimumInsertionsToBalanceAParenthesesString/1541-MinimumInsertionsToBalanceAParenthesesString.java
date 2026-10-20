// Last updated: 10/20/2026, 9:32:49 PM
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int reqRight = 0;
        
        // Convert to primitive array for blazing fast, direct memory access
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                // If reqRight is odd, it means we have an orphaned ')' from a previous pair.
                // We must balance it immediately by inserting one ')' before processing this new '('.
                if ((reqRight & 1) == 1) {
                    insertions++; // Insert the missing ')'
                    reqRight--;   // We fulfilled that specific need
                }
                // Every new '(' strictly requires two ')'
                reqRight += 2;
            } else {
                // We found a ')'
                reqRight--;
                
                // If reqRight drops below 0, it means we have a ')' with no matching '('.
                if (reqRight < 0) {
                    insertions++; // Insert a missing '('
                    // The inserted '(' requires two ')'. We just consumed one, so we still need 1 more.
                    reqRight = 1; 
                }
            }
        }
        
        // Any remaining required right brackets must be inserted at the very end
        return insertions + reqRight;
    }
}
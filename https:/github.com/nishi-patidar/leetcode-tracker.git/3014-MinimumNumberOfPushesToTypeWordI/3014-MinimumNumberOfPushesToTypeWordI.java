// Last updated: 10/1/2026, 2:58:57 PM
class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;
        
        for (int i = 0; i < n; i++) {
            pushes += (i / 8) + 1;
        }
        
        return pushes;
    }
}

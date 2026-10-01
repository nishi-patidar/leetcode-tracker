// Last updated: 10/1/2026, 2:58:55 PM
class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }
        
        java.util.Arrays.sort(freq);
        
        int totalPushes = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[25 - i] == 0) {
                break;
            }
            totalPushes += freq[25 - i] * ((i / 8) + 1);
        }
        
        return totalPushes;
    }
}

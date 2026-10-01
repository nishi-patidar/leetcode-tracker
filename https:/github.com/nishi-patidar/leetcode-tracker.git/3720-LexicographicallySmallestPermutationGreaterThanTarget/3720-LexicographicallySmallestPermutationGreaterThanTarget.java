// Last updated: 10/1/2026, 2:55:59 PM
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] sArr = s.toCharArray();
        char[] tArr = target.toCharArray();
        int n = sArr.length;
        
        int[] counts = new int[26];
        for (char c : sArr) {
            counts[c - 'a']++;
        }
        
        int bestI = -1;
        char bestChar = 0;
        
        for (int i = 0; i < n; i++) {
            int tc = tArr[i] - 'a';
            
            for (int c = tc + 1; c < 26; c++) {
                if (counts[c] > 0) {
                    bestI = i;
                    bestChar = (char) (c + 'a');
                    break;
                }
            }
            
            if (counts[tc] > 0) {
                counts[tc]--;
            } else {
                break;
            }
        }
        
        if (bestI == -1) {
            return "";
        }
        
        char[] res = new char[n];
        int[] remain = new int[26];
        for (char c : sArr) {
            remain[c - 'a']++;
        }
        
        for (int i = 0; i < bestI; i++) {
            res[i] = tArr[i];
            remain[res[i] - 'a']--;
        }
        
        res[bestI] = bestChar;
        remain[bestChar - 'a']--;
        
        int idx = bestI + 1;
        for (int c = 0; c < 26; c++) {
            while (remain[c] > 0) {
                res[idx++] = (char) (c + 'a');
                remain[c]--;
            }
        }
        
        return new String(res);
    }
}
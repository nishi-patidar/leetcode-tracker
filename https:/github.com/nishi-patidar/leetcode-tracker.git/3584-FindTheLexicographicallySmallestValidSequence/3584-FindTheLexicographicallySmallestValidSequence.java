// Last updated: 8/11/2026, 1:50:00 PM
class Solution {
    public int[] validSequence(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        int[] R = new int[M + 1];
        int jSuf = N - 1;
        
        for (int i = M - 1; i >= 0; i--) {
            if (jSuf >= 0 && word1.charAt(i) == word2.charAt(jSuf)) {
                jSuf--;
            }
            R[i] = N - 1 - jSuf;
        }
        
        int[] res = new int[N];
        int j = 0;
        boolean changed = false;
        
        for (int i = 0; i < M; i++) {
            if (j == N) break;
            
            if (changed) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    res[j] = i;
                    j++;
                }
            } else {
                if (word1.charAt(i) == word2.charAt(j)) {
                    res[j] = i;
                    j++;
                } else if (R[i + 1] >= N - 1 - j) {
                    res[j] = i;
                    j++;
                    changed = true;
                }
            }
        }
        
        if (j == N) {
            return res;
        }
        
        return new int[0];
    }
}
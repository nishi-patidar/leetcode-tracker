// Last updated: 10/1/2026, 2:57:38 PM
class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (count[i] == 0) continue;
            count[i]--;
            
            for (int j = 0; j <= 9; j++) {
                if (count[j] == 0) continue;
                count[j]--;
                
                for (int k = 0; k <= 8; k += 2) {
                    if (count[k] > 0) {
                        res++;
                    }
                }
                
                count[j]++;
            }
            
            count[i]++;
        }
        
        return res;
    }
}
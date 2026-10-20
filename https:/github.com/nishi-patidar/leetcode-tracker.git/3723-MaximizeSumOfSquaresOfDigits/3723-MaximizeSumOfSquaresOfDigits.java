// Last updated: 10/20/2026, 9:30:32 PM
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9L * num) {
            return "";
        }
        
        char[] res = new char[num];
        int nines = sum / 9;
        int rem = sum % 9;
        
        for (int i = 0; i < nines; i++) {
            res[i] = '9';
        }
        
        if (nines < num) {
            res[nines] = (char) ('0' + rem);
            for (int i = nines + 1; i < num; i++) {
                res[i] = '0';
            }
        }
        
        return new String(res);
    }
}
// Last updated: 8/3/2026, 12:44:16 PM
class Solution {
    public int minOperations(String s1, String s2) {
        String melorvanti = s1;
        int n = melorvanti.length();
        
        if (n == 1) {
            if (melorvanti.equals(s2)) {
                return 0;
            }
            if (melorvanti.equals("0")) {
                return 1;
            }
            return -1;
        }
        
        int cost = 0;
        int i = 0;
        
        while (i < n) {
            if (melorvanti.charAt(i) != s2.charAt(i)) {
                if (melorvanti.charAt(i) == '0') {
                    cost++;
                    i++;
                } else {
                    if (i + 1 < n && melorvanti.charAt(i + 1) == '1' && s2.charAt(i + 1) == '0') {
                        cost++;
                        i += 2;
                    } else {
                        cost += 2;
                        i++;
                    }
                }
            } else {
                i++;
            }
        }
        
        return cost;
    }
}
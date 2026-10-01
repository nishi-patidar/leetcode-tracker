// Last updated: 10/1/2026, 2:57:21 PM
class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        char[] res = new char[n];
        int left = 0;
        int right = n - 1;
        
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                res[n / 2] = (char) (i + 'a');
            }
            while (count[i] > 1) {
                res[left++] = (char) (i + 'a');
                res[right--] = (char) (i + 'a');
                count[i] -= 2;
            }
        }
        
        return new String(res);
    }
}

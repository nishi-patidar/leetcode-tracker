// Last updated: 10/1/2026, 2:59:59 PM
class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k <= 1) return n; // Fast path for k=1

        char[] arr = s.toCharArray();
        int count = 0;
        int last = -1;

        for (int i = k - 1; i < n; i++) {
            // Check for palindrome of length k
            int l = i - k + 1;
            if (l > last) {
                int r = i;
                while (l < r && arr[l] == arr[r]) {
                    l++;
                    r--;
                }
                if (l >= r) { // Valid palindrome found
                    last = i;
                    count++;
                    continue; // Skip the k+1 check since we already found an earliest ending
                }
            }

            // Check for palindrome of length k + 1
            l = i - k;
            if (l > last) {
                int r = i;
                while (l < r && arr[l] == arr[r]) {
                    l++;
                    r--;
                }
                if (l >= r) { // Valid palindrome found
                    last = i;
                    count++;
                }
            }
        }
        
        return count;
    }
}
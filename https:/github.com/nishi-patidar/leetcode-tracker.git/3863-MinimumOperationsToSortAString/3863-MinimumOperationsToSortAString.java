// Last updated: 10/30/2026, 8:36:31 PM
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // 1. Check if the string is already sorted (O(N) time, O(1) space)
        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            return 0;
        }
        
        if (n == 2) {
            return -1;
        }
        
        // 2. Frequency counting for O(N) linear time sorting validation
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        // 3. Find if there's any matching prefix
        int expectedChar = 0;
        int L = 0;
        int[] tempCounts = counts.clone();
        for (int i = 0; i < n; i++) {
            while (expectedChar < 26 && tempCounts[expectedChar] == 0) {
                expectedChar++;
            }
            if (s.charAt(i) - 'a' == expectedChar) {
                L++;
                tempCounts[expectedChar]--;
            } else {
                break;
            }
        }
        
        // 4. Find if there's any matching suffix
        expectedChar = 25;
        int R = n - 1;
        tempCounts = counts.clone(); // Reset counts for suffix checking
        for (int i = n - 1; i >= 0; i--) {
            while (expectedChar >= 0 && tempCounts[expectedChar] == 0) {
                expectedChar--;
            }
            if (s.charAt(i) - 'a' == expectedChar) {
                R--;
                tempCounts[expectedChar]--;
            } else {
                break;
            }
        }
        
        // If misplaced elements do not span the entire string, it takes 1 operation.
        if (L > 0 || R < n - 1) {
            return 1;
        }
        
        // 5. Determine absolute min and max characters present
        int minCharIdx = 0, maxCharIdx = 25;
        while (counts[minCharIdx] == 0) minCharIdx++;
        while (counts[maxCharIdx] == 0) maxCharIdx--;
        
        // If the absolute maximum is stuck at the first position AND 
        // the absolute minimum is stuck at the last position, 
        // we strictly require 3 operations. 
        if (s.charAt(0) - 'a' == maxCharIdx && counts[maxCharIdx] == 1 &&
            s.charAt(n - 1) - 'a' == minCharIdx && counts[minCharIdx] == 1) {
            return 3;
        }
        
        // Otherwise, 2 operations are sufficient
        return 2;
    }
}
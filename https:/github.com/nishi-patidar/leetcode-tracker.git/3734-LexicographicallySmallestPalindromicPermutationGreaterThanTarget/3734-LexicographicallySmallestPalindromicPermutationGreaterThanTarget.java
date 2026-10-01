// Last updated: 10/1/2026, 2:55:53 PM
class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                oddCount++;
                midChar = (char) (i + 'a');
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int[] halfCounts = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCounts[i] = counts[i] / 2;
        }

        int m = n / 2;
        boolean canMatchExact = true;
        int[] tempCounts = halfCounts.clone();
        char[] exactHalf = new char[m];
        
        for (int i = 0; i < m; i++) {
            int c = target.charAt(i) - 'a';
            if (tempCounts[c] > 0) {
                tempCounts[c]--;
                exactHalf[i] = (char) (c + 'a');
            } else {
                canMatchExact = false;
                break;
            }
        }

        if (canMatchExact) {
            char[] full = new char[n];
            for (int i = 0; i < m; i++) {
                full[i] = exactHalf[i];
                full[n - 1 - i] = exactHalf[i];
            }
            if (n % 2 != 0) {
                full[m] = midChar;
            }
            String fullStr = new String(full);
            if (fullStr.compareTo(target) > 0) {
                return fullStr;
            }
        }

        int bestI = -1;
        char bestChar = 0;
        tempCounts = halfCounts.clone();

        for (int i = 0; i < m; i++) {
            int tc = target.charAt(i) - 'a';
            
            for (int c = tc + 1; c < 26; c++) {
                if (tempCounts[c] > 0) {
                    bestI = i;
                    bestChar = (char) (c + 'a');
                    break;
                }
            }

            if (tempCounts[tc] > 0) {
                tempCounts[tc]--;
            } else {
                break;
            }
        }

        if (bestI == -1) {
            return "";
        }

        tempCounts = halfCounts.clone();
        char[] resHalf = new char[m];
        
        for (int i = 0; i < bestI; i++) {
            resHalf[i] = target.charAt(i);
            tempCounts[target.charAt(i) - 'a']--;
        }
        
        resHalf[bestI] = bestChar;
        tempCounts[bestChar - 'a']--;
        
        int idx = bestI + 1;
        for (int c = 0; c < 26; c++) {
            while (tempCounts[c] > 0) {
                resHalf[idx++] = (char) (c + 'a');
                tempCounts[c]--;
            }
        }

        char[] fullRes = new char[n];
        for (int i = 0; i < m; i++) {
            fullRes[i] = resHalf[i];
            fullRes[n - 1 - i] = resHalf[i];
        }
        if (n % 2 != 0) {
            fullRes[m] = midChar;
        }

        return new String(fullRes);
    }
}
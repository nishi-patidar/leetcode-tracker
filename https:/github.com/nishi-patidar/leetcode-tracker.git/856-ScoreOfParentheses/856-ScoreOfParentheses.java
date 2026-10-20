// Last updated: 10/20/2026, 9:33:20 PM
class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                depth++;
            } else {
                depth--;
                if (arr[i - 1] == '(') {
                    score += 1 << depth;
                }
            }
        }
        
        return score;
    }
}
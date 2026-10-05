// Last updated: 10/5/2026, 2:09:54 PM
1class Solution {
2    public int scoreOfParentheses(String s) {
3        int score = 0;
4        int depth = 0;
5        char[] arr = s.toCharArray();
6        
7        for (int i = 0; i < arr.length; i++) {
8            if (arr[i] == '(') {
9                depth++;
10            } else {
11                depth--;
12                if (arr[i - 1] == '(') {
13                    score += 1 << depth;
14                }
15            }
16        }
17        
18        return score;
19    }
20}
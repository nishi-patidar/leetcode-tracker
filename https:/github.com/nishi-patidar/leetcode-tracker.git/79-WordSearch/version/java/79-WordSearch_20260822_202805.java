// Last updated: 8/22/2026, 8:28:05 PM
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int m = board.length;
4        int n = board[0].length;
5        
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (dfs(board, word, i, j, 0)) {
9                    return true;
10                }
11            }
12        }
13        
14        return false;
15    }
16
17    private boolean dfs(char[][] board, String word, int i, int j, int index) {
18        if (index == word.length()) {
19            return true;
20        }
21        
22        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
23            return false;
24        }
25
26        char temp = board[i][j];
27        board[i][j] = '#'; 
28
29        boolean found = dfs(board, word, i + 1, j, index + 1)
30                     || dfs(board, word, i - 1, j, index + 1)
31                     || dfs(board, word, i, j + 1, index + 1)
32                     || dfs(board, word, i, j - 1, index + 1);
33
34        board[i][j] = temp; 
35
36        return found;
37    }
38}
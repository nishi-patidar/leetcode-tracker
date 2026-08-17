// Last updated: 8/17/2026, 12:37:35 PM
1class Solution {
2    public String convert(String s, int numRows) {
3        if (numRows == 1 || numRows >= s.length()) {
4            return s;
5        }
6
7        StringBuilder[] rows = new StringBuilder[numRows];
8        for (int i = 0; i < numRows; i++) {
9            rows[i] = new StringBuilder();
10        }
11
12        int currRow = 0;
13        boolean goingDown = false;
14
15        for (char c : s.toCharArray()) {
16            rows[currRow].append(c);
17            if (currRow == 0 || currRow == numRows - 1) {
18                goingDown = !goingDown;
19            }
20            currRow += goingDown ? 1 : -1;
21        }
22
23        StringBuilder ret = new StringBuilder();
24        for (StringBuilder row : rows) {
25            ret.append(row);
26        }
27
28        return ret.toString();
29    }
30}
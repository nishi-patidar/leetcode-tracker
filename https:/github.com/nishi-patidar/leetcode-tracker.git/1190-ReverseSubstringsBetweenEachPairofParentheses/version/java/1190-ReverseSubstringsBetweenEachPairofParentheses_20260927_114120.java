// Last updated: 9/27/2026, 11:41:20 AM
1class Solution {
2    public String reverseParentheses(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length;
5        int[] pair = new int[n];
6        int[] stack = new int[n];
7        int top = -1;
8        
9        for (int i = 0; i < n; i++) {
10            if (arr[i] == '(') {
11                stack[++top] = i;
12            } else if (arr[i] == ')') {
13                int j = stack[top--];
14                pair[i] = j;
15                pair[j] = i;
16            }
17        }
18        
19        StringBuilder sb = new StringBuilder(n);
20        int i = 0, dir = 1;
21        while (i >= 0 && i < n) {
22            if (arr[i] == '(' || arr[i] == ')') {
23                i = pair[i];
24                dir = -dir;
25            } else {
26                sb.append(arr[i]);
27            }
28            i += dir;
29        }
30        
31        return sb.toString();
32    }
33}
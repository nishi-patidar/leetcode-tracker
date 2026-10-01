// Last updated: 10/1/2026, 3:02:31 PM
class Solution {
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] pair = new int[n];
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                stack[++top] = i;
            } else if (arr[i] == ')') {
                int j = stack[top--];
                pair[i] = j;
                pair[j] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder(n);
        int i = 0, dir = 1;
        while (i >= 0 && i < n) {
            if (arr[i] == '(' || arr[i] == ')') {
                i = pair[i];
                dir = -dir;
            } else {
                sb.append(arr[i]);
            }
            i += dir;
        }
        
        return sb.toString();
    }
}
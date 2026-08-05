// Last updated: 8/5/2026, 7:27:43 PM
1import java.util.ArrayDeque;
2import java.util.Deque;
3
4class Solution {
5    public String simplifyPath(String path) {
6        String[] parts = path.split("/");
7        Deque<String> stack = new ArrayDeque<>();
8        
9        for (String part : parts) {
10            if (part.equals("") || part.equals(".")) {
11                continue;
12            }
13            if (part.equals("..")) {
14                if (!stack.isEmpty()) {
15                    stack.pollLast();
16                }
17            } else {
18                stack.addLast(part);
19            }
20        }
21        
22        StringBuilder res = new StringBuilder();
23        for (String dir : stack) {
24            res.append("/");
25            res.append(dir);
26        }
27        
28        return res.length() > 0 ? res.toString() : "/";
29    }
30}
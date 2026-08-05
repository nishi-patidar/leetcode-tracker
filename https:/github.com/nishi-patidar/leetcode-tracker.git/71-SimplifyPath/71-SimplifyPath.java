// Last updated: 8/5/2026, 7:29:59 PM
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.addLast(part);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/");
            res.append(dir);
        }
        
        return res.length() > 0 ? res.toString() : "/";
    }
}
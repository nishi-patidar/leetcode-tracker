// Last updated: 10/20/2026, 9:33:37 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, 0, new char[]{'(', ')'}, ans);
        return ans;
    }

    private void dfs(String s, int last_i, int last_j, char[] par, List<String> ans) {
        int stack = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1), i, j, par, ans);
                }
            }
            return;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            dfs(reversed, 0, 0, new char[]{')', '('}, ans);
        } else {
            ans.add(reversed);
        }
    }
}
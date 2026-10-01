// Last updated: 10/1/2026, 3:02:56 PM
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List braceExpansionII(String expression) {
        int[] pos = new int[1];
        Set set = new HashSet(parse(expression.toCharArray(), pos));
        List ans = new ArrayList(set);
        Collections.sort(ans);
        return ans;
    }

    private List parse(char[] exp, int[] pos) {
        List res = new ArrayList();
        List cur = new ArrayList();
        cur.add("");

        while (pos[0] < exp.length && exp[pos[0]] != '}') {
            if (exp[pos[0]] == ',') {
                for (int i = 0; i < cur.size(); i++) {
                    res.add((String) cur.get(i));
                }
                cur = new ArrayList();
                cur.add("");
                pos[0]++;
            } else if (exp[pos[0]] == '{') {
                pos[0]++;
                List next = parse(exp, pos);
                pos[0]++;
                
                List temp = new ArrayList();
                for (int i = 0; i < cur.size(); i++) {
                    String s1 = (String) cur.get(i);
                    for (int j = 0; j < next.size(); j++) {
                        String s2 = (String) next.get(j);
                        temp.add(s1 + s2);
                    }
                }
                cur = temp;
            } else {
                int start = pos[0];
                while (pos[0] < exp.length && exp[pos[0]] >= 'a' && exp[pos[0]] <= 'z') {
                    pos[0]++;
                }
                String str = new String(exp, start, pos[0] - start);
                
                List temp = new ArrayList();
                for (int i = 0; i < cur.size(); i++) {
                    String s1 = (String) cur.get(i);
                    temp.add(s1 + str);
                }
                cur = temp;
            }
        }
        for (int i = 0; i < cur.size(); i++) {
            res.add((String) cur.get(i));
        }
        return res;
    }
}
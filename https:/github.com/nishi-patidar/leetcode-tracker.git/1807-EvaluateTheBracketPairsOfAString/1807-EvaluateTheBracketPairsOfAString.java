// Last updated: 10/1/2026, 3:01:17 PM
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List< List< String > > knowledge) {
        Map< String, String > dict = new HashMap< String, String >();
        for (List< String > pair : knowledge) {
            dict.put(pair.get(0), pair.get(1));
        }
        
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        int i = 0;
        int n = arr.length;
        
        while (i < n) {
            if (arr[i] == '(') {
                i++;
                int start = i;
                while (arr[i] != ')') {
                    i++;
                }
                String key = new String(arr, start, i - start);
                String val = dict.get(key);
                if (val != null) {
                    res.append(val);
                } else {
                    res.append('?');
                }
            } else {
                res.append(arr[i]);
            }
            i++;
        }
        
        return res.toString();
    }
}
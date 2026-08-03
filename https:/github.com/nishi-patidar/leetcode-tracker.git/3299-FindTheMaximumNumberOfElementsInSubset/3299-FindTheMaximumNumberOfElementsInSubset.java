// Last updated: 8/3/2026, 12:46:25 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (int num : nums) {
            long val = (long) num;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int max = 1;
        
        if (map.containsKey(1L)) {
            int count = map.get(1L);
            if (count % 2 == 0) {
                count--;
            }
            max = Math.max(max, count);
        }
        
        for (long x : map.keySet()) {
            if (x == 1L) {
                continue;
            }
            
            int len = 0;
            long curr = x;
            
            while (map.containsKey(curr)) {
                int count = map.get(curr);
                if (count >= 2) {
                    len += 2;
                    curr *= curr;
                } else {
                    len += 1;
                    break;
                }
            }
            
            if (len % 2 == 0) {
                len -= 1;
            }
            
            max = Math.max(max, len);
        }
        
        return max;
    }
}

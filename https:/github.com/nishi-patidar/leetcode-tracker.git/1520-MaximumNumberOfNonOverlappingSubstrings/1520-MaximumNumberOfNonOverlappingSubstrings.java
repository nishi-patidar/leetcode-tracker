// Last updated: 10/1/2026, 3:01:50 PM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int c = arr[i] - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        
        List<int[]> intervals = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                int start = first[i];
                int end = last[i];
                boolean valid = true;
                
                for (int j = start; j <= end; j++) {
                    int c = arr[j] - 'a';
                    if (first[c] < start) {
                        valid = false;
                        break;
                    }
                    if (last[c] > end) {
                        end = last[c];
                    }
                }
                
                if (valid) {
                    intervals.add(new int[]{start, end});
                }
            }
        }
        
        intervals.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        List<String> result = new ArrayList<>();
        int lastEnd = -1;
        
        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                result.add(new String(arr, interval[0], interval[1] - interval[0] + 1));
                lastEnd = interval[1];
            }
        }
        
        return result;
    }
}
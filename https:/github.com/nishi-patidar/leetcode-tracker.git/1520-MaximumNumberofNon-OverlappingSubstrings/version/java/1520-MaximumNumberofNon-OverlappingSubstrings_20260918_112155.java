// Last updated: 9/18/2026, 11:21:55 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<String> maxNumOfSubstrings(String s) {
7        int n = s.length();
8        int[] first = new int[26];
9        int[] last = new int[26];
10        Arrays.fill(first, -1);
11        Arrays.fill(last, -1);
12        
13        char[] arr = s.toCharArray();
14        for (int i = 0; i < n; i++) {
15            int c = arr[i] - 'a';
16            if (first[c] == -1) {
17                first[c] = i;
18            }
19            last[c] = i;
20        }
21        
22        List<int[]> intervals = new ArrayList<>();
23        
24        for (int i = 0; i < 26; i++) {
25            if (first[i] != -1) {
26                int start = first[i];
27                int end = last[i];
28                boolean valid = true;
29                
30                for (int j = start; j <= end; j++) {
31                    int c = arr[j] - 'a';
32                    if (first[c] < start) {
33                        valid = false;
34                        break;
35                    }
36                    if (last[c] > end) {
37                        end = last[c];
38                    }
39                }
40                
41                if (valid) {
42                    intervals.add(new int[]{start, end});
43                }
44            }
45        }
46        
47        intervals.sort((a, b) -> {
48            if (a[1] != b[1]) {
49                return Integer.compare(a[1], b[1]);
50            }
51            return Integer.compare(b[0], a[0]);
52        });
53        
54        List<String> result = new ArrayList<>();
55        int lastEnd = -1;
56        
57        for (int[] interval : intervals) {
58            if (interval[0] > lastEnd) {
59                result.add(new String(arr, interval[0], interval[1] - interval[0] + 1));
60                lastEnd = interval[1];
61            }
62        }
63        
64        return result;
65    }
66}
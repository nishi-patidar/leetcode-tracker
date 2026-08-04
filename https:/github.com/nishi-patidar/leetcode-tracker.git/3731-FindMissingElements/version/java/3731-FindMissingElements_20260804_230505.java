// Last updated: 8/4/2026, 11:05:05 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> findMissingElements(int[] nums) {
6        int min = 101;
7        int max = 0;
8        boolean[] present = new boolean[101];
9        
10        for (int num : nums) {
11            if (num < min) {
12                min = num;
13            }
14            if (num > max) {
15                max = num;
16            }
17            present[num] = true;
18        }
19        
20        List<Integer> result = new ArrayList<>();
21        for (int i = min + 1; i < max; i++) {
22            if (!present[i]) {
23                result.add(i);
24            }
25        }
26        
27        return result;
28    }
29}
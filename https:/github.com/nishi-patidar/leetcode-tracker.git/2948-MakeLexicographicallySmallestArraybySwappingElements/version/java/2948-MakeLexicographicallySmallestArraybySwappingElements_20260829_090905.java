// Last updated: 8/29/2026, 9:09:05 AM
1import java.util.Arrays;
2
3class Solution {
4    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
5        int n = nums.length;
6        int[][] pairs = new int[n][2];
7        for (int i = 0; i < n; i++) {
8            pairs[i][0] = nums[i];
9            pairs[i][1] = i;
10        }
11        
12        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
13        
14        int[] result = new int[n];
15        int i = 0;
16        while (i < n) {
17            int j = i + 1;
18            while (j < n && pairs[j][0] - pairs[j - 1][0] <= limit) {
19                j++;
20            }
21            
22            int[] indices = new int[j - i];
23            for (int k = i; k < j; k++) {
24                indices[k - i] = pairs[k][1];
25            }
26            Arrays.sort(indices);
27            
28            for (int k = i; k < j; k++) {
29                result[indices[k - i]] = pairs[k][0];
30            }
31            
32            i = j;
33        }
34        
35        return result;
36    }
37}
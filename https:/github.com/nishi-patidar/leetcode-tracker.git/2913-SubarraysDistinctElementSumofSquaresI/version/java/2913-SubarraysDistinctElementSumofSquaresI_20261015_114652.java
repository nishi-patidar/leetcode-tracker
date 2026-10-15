// Last updated: 10/15/2026, 11:46:52 AM
1import java.util.List;
2
3class Solution {
4    public int sumCounts(List<Integer> nums) {
5        int ans = 0;
6        int n = nums.size();
7        for (int i = 0; i < n; i++) {
8            boolean[] seen = new boolean[101];
9            int count = 0;
10            for (int j = i; j < n; j++) {
11                int val = nums.get(j);
12                if (!seen[val]) {
13                    seen[val] = true;
14                    count++;
15                }
16                ans += count * count;
17            }
18        }
19        return ans;
20    }
21}
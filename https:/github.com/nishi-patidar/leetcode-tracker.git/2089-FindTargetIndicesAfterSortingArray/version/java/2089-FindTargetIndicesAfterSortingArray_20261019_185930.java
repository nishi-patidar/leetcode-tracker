// Last updated: 10/19/2026, 6:59:30 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> targetIndices(int[] nums, int target) {
6        int lessThan = 0;
7        int count = 0;
8        
9        for (int num : nums) {
10            if (num < target) {
11                lessThan++;
12            } else if (num == target) {
13                count++;
14            }
15        }
16        
17        List<Integer> result = new ArrayList<>();
18        for (int i = 0; i < count; i++) {
19            result.add(lessThan + i);
20        }
21        
22        return result;
23    }
24}
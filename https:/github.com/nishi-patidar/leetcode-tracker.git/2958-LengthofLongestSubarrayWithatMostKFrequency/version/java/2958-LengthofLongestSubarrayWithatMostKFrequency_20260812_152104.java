// Last updated: 8/12/2026, 3:21:04 PM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public int maxSubarrayLength(int[] nums, int k) {
6        Map<Integer, Integer> freq = new HashMap<>();
7        int left = 0;
8        int maxLen = 0;
9        
10        for (int right = 0; right < nums.length; right++) {
11            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
12            
13            while (freq.get(nums[right]) > k) {
14                freq.put(nums[left], freq.get(nums[left]) - 1);
15                left++;
16            }
17            
18            maxLen = Math.max(maxLen, right - left + 1);
19        }
20        
21        return maxLen;
22    }
23}
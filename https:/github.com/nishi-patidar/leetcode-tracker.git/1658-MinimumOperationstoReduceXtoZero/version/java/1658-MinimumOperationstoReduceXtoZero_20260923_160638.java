// Last updated: 9/23/2026, 4:06:38 PM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        int totalSum = 0;
4        for (int num : nums) {
5            totalSum += num;
6        }
7        
8        int target = totalSum - x;
9        if (target < 0) {
10            return -1;
11        }
12        
13        if (target == 0) {
14            return nums.length;
15        }
16        
17        int maxLength = -1;
18        int currentSum = 0;
19        int left = 0;
20        
21        for (int right = 0; right < nums.length; right++) {
22            currentSum += nums[right];
23            
24            while (currentSum > target && left <= right) {
25                currentSum -= nums[left];
26                left++;
27            }
28            
29            if (currentSum == target) {
30                if (right - left + 1 > maxLength) {
31                    maxLength = right - left + 1;
32                }
33            }
34        }
35        
36        return maxLength != -1 ? nums.length - maxLength : -1;
37    }
38}
// Last updated: 8/29/2026, 9:11:42 AM
1class Solution {
2    public boolean search(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length - 1;
5        
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8            
9            if (nums[mid] == target) {
10                return true;
11            }
12            
13            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
14                left++;
15                right--;
16            } else if (nums[left] <= nums[mid]) {
17                if (nums[left] <= target && target < nums[mid]) {
18                    right = mid - 1;
19                } else {
20                    left = mid + 1;
21                }
22            } else {
23                if (nums[mid] < target && target <= nums[right]) {
24                    left = mid + 1;
25                } else {
26                    right = mid - 1;
27                }
28            }
29        }
30        
31        return false;
32    }
33}
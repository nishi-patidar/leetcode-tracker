// Last updated: 8/12/2026, 3:27:55 PM
1class Solution {
2    public void sortColors(int[] nums) {
3        int low = 0;
4        int mid = 0;
5        int high = nums.length - 1;
6        
7        while (mid <= high) {
8            if (nums[mid] == 0) {
9                int temp = nums[low];
10                nums[low] = nums[mid];
11                nums[mid] = temp;
12                low++;
13                mid++;
14            } else if (nums[mid] == 1) {
15                mid++;
16            } else {
17                int temp = nums[high];
18                nums[high] = nums[mid];
19                nums[mid] = temp;
20                high--;
21            }
22        }
23    }
24}
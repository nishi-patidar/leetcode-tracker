// Last updated: 10/10/2026, 8:11:31 PM
1class Solution {
2    public int[] maxProductPair(int[] nums, int target) {
3        int[] ans = {-1, -1};
4        long max = Long.MIN_VALUE;
5        for(int i=0; i<nums.length; i++){
6            for(int j =0; j<i; j++){
7                if(nums[i] +nums[j] == target && nums[i] != nums[j] && (long)nums[i] * nums[j] > max){
8                    max = (long)nums[i] *nums[j];
9                    ans = nums[i] > nums[j] ? new int[]{i,j} : new int[]{j, i};
10                }
11            }
12        }
13        return ans;
14    }
15}
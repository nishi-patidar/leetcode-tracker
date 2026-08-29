// Last updated: 8/29/2026, 11:55:02 PM
1class Solution {
2    public String[] largestString(int[] nums) {
3       String[] ans = new String[nums.length];
4        for(int i=0; i<nums.length; i++){
5            StringBuilder sb = new StringBuilder();
6            int x=nums[i];
7            for(int bit=0; bit<25 && x>0; bit++){
8                if((x & 1) == 1){
9                    sb.append((char) ('a' +bit));
10                }
11                x >>=1;
12            }
13            while (x-- >0){
14                sb.append('z');
15            }
16            ans[i] = sb.reverse().toString();
17        }
18        return ans;
19    }
20}
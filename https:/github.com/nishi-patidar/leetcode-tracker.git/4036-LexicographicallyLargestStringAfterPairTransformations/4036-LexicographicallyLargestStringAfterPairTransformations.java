// Last updated: 10/1/2026, 2:54:11 PM
class Solution {
    public String[] largestString(int[] nums) {
       String[] ans = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            StringBuilder sb = new StringBuilder();
            int x=nums[i];
            for(int bit=0; bit<25 && x>0; bit++){
                if((x & 1) == 1){
                    sb.append((char) ('a' +bit));
                }
                x >>=1;
            }
            while (x-- >0){
                sb.append('z');
            }
            ans[i] = sb.reverse().toString();
        }
        return ans;
    }
}
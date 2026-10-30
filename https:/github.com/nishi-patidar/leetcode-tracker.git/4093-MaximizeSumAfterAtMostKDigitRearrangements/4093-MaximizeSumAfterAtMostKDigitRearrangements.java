// Last updated: 10/30/2026, 8:36:19 PM
import java.util.Arrays;
class Solution {
    public long maximizeSum(int[] nums, int k) {
       long sum=0;
        int n=nums.length;
        int[]  gains = new int[n];

        for(int i=0; i<n; i++){
            sum+= nums[i];
            int maxVal=0, temp = nums[i];
            int[] c=new int[10];
            while (temp>0){
                c[temp % 10]++;
                temp/=10;
            }
            for(int d=9; d>=0; d--){
                while (c[d]-- > 0){
                    maxVal = maxVal *10 + d;
                }
            }
            gains[i] = maxVal - nums[i];
        }
        Arrays.sort(gains);
        for(int i=n-1; i>= Math.max(0, n-k) && gains[i] > 0; i--){
            sum+= gains[i];
        }
        return sum;
    }
}
// Last updated: 10/1/2026, 2:53:57 PM
class Solution {
    public int minOperations(int[] nums, int sum) {
       int []dp= new int[sum+1];
        Arrays.fill(dp, 1000000);
        dp[0]=0;

        for(int x: nums){
            Map<Integer,Integer> cost=new HashMap<>();

            for(int mult=0; mult<=14 && (long) x*(1<<mult)<=10000; mult++){
                int cur =x<<mult;
                int div =0;

                while(cur>=0){
                    if(cur<=sum){
                        cost.put(cur, Math.min(cost.getOrDefault(cur, 1000000), mult+div));
                    }
                    if(cur==0) break;
                    cur/=2;
                    div++;
                }
            }
            int[] next = dp.clone();
            for(int s=0; s<=sum;s++){
                if(dp[s]==1000000) continue;
                for(Map.Entry<Integer, Integer>e: cost.entrySet()){
                    int val=e.getKey();
                    int c=e.getValue();
                    if(s+val<=sum){
                        next[s+val]=Math.min(next[s+val], dp[s]+c);
                    }
                }
            }
            dp=next;
        }
        return dp[sum]>=1000000 ? -1: dp[sum];
    }
}
// Last updated: 8/30/2026, 8:40:29 AM
1class Solution {
2    public int minOperations(int[] nums, int sum) {
3       int []dp= new int[sum+1];
4        Arrays.fill(dp, 1000000);
5        dp[0]=0;
6
7        for(int x: nums){
8            Map<Integer,Integer> cost=new HashMap<>();
9
10            for(int mult=0; mult<=14 && (long) x*(1<<mult)<=10000; mult++){
11                int cur =x<<mult;
12                int div =0;
13
14                while(cur>=0){
15                    if(cur<=sum){
16                        cost.put(cur, Math.min(cost.getOrDefault(cur, 1000000), mult+div));
17                    }
18                    if(cur==0) break;
19                    cur/=2;
20                    div++;
21                }
22            }
23            int[] next = dp.clone();
24            for(int s=0; s<=sum;s++){
25                if(dp[s]==1000000) continue;
26                for(Map.Entry<Integer, Integer>e: cost.entrySet()){
27                    int val=e.getKey();
28                    int c=e.getValue();
29                    if(s+val<=sum){
30                        next[s+val]=Math.min(next[s+val], dp[s]+c);
31                    }
32                }
33            }
34            dp=next;
35        }
36        return dp[sum]>=1000000 ? -1: dp[sum];
37    }
38}
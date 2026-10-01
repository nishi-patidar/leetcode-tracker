// Last updated: 10/1/2026, 2:53:34 PM
class Solution {
    public int minDays(int n) {
        int [] dp= new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0]=-1;

        for(int k = 1; k* (k+1)/2 <=n; k++){
            int points= k*(k+1)/2;
            int days = k +1;
            for (int i =points ; i<=n; i++){
                dp[i] = Math.min(dp[i], dp[i - points]+ days);
            }
        }
        return dp[n];
    }
}
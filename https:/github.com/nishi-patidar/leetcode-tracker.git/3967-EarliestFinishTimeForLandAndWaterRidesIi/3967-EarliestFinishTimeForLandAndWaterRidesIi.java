// Last updated: 8/3/2026, 12:45:07 PM
import java.util.Arrays;

class Solution {
    private int solve(int[] s1, int[] d1, int[] s2, int[] d2) {
        int n = s1.length;
        int m = s2.length;
        
        int[][] rides2 = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides2[i][0] = s2[i];
            rides2[i][1] = d2[i];
        }
        
        Arrays.sort(rides2, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] starts2 = new int[m];
        for (int i = 0; i < m; i++) {
            starts2[i] = rides2[i][0];
        }
        
        int[] prefMinD = new int[m];
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            currMin = Math.min(currMin, rides2[i][1]);
            prefMinD[i] = currMin;
        }
        
        int[] suffMinSum = new int[m];
        int currMinSum = Integer.MAX_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            currMinSum = Math.min(currMinSum, rides2[i][0] + rides2[i][1]);
            suffMinSum[i] = currMinSum;
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int C = s1[i] + d1[i];
            
            int low = 0, high = m;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (starts2[mid] <= C) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int idx = low;
            
            int cost = Integer.MAX_VALUE;
            if (idx > 0) {
                cost = Math.min(cost, C + prefMinD[idx - 1]);
            }
            if (idx < m) {
                cost = Math.min(cost, suffMinSum[idx]);
            }
            
            ans = Math.min(ans, cost);
        }
        return ans;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }
}

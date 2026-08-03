// Last updated: 8/3/2026, 12:45:10 PM
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;
        
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                int landEnd = landStartTime[i] + landDuration[i];
                int waterEndAfterLand = Math.max(landEnd, waterStartTime[j]) + waterDuration[j];
                
                int waterEnd = waterStartTime[j] + waterDuration[j];
                int landEndAfterWater = Math.max(waterEnd, landStartTime[i]) + landDuration[i];
                
                minTime = Math.min(minTime, Math.min(waterEndAfterLand, landEndAfterWater));
            }
        }
        
        return minTime;
    }
}

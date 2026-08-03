// Last updated: 8/3/2026, 12:49:17 PM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] result = new int[n + 1][2];
        int i = 0;
        int idx = 0;
        
        while (i < n && intervals[i][1] < newInterval[0]) {
            result[idx++] = intervals[i++];
        }
        
        while (i < n && intervals[i][0] <= newInterval[1]) {
            if (intervals[i][0] < newInterval[0]) {
                newInterval[0] = intervals[i][0];
            }
            if (intervals[i][1] > newInterval[1]) {
                newInterval[1] = intervals[i][1];
            }
            i++;
        }
        
        result[idx++] = newInterval;
        
        while (i < n) {
            result[idx++] = intervals[i++];
        }
        
        int[][] finalResult = new int[idx][2];
        System.arraycopy(result, 0, finalResult, 0, idx);
        
        return finalResult;
    }
}

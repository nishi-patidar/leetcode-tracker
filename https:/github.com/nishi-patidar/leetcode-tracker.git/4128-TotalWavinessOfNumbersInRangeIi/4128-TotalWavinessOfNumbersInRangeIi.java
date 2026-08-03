// Last updated: 8/3/2026, 12:44:38 PM
class Solution {
    private long[][][][][] memoWays;
    private long[][][][][] memoWaves;
    private boolean[][][][][] visited;
    private String numStr;

    // Renamed to match LeetCode's expected method signature
    public long totalWaviness(long num1, long num2) {
        return solve(String.valueOf(num2)) - solve(String.valueOf(num1 - 1));
    }

    private long solve(String s) {
        this.numStr = s;
        int n = s.length();
        
        memoWays = new long[n][2][2][11][11];
        memoWaves = new long[n][2][2][11][11];
        visited = new boolean[n][2][2][11][11];
        
        dfs(0, 1, 1, -1, -1);
        
        return memoWaves[0][1][1][0][0]; 
    }

    private void dfs(int idx, int isTight, int isLeadingZero, int d1, int d2) {
        int d1Idx = d1 + 1;
        int d2Idx = d2 + 1;

        if (visited[idx][isTight][isLeadingZero][d1Idx][d2Idx]) {
            return;
        }

        int limit = (isTight == 1) ? (numStr.charAt(idx) - '0') : 9;
        long ways = 0;
        long waves = 0;

        for (int d = 0; d <= limit; d++) {
            int nxtTight = (isTight == 1 && d == limit) ? 1 : 0;
            int nxtLeadZero = (isLeadingZero == 1 && d == 0) ? 1 : 0;

            int nxtD1 = d;
            int nxtD2 = d1;

            if (isLeadingZero == 1) {
                if (d == 0) {
                    nxtD1 = -1;
                    nxtD2 = -1;
                } else {
                    nxtD1 = d;
                    nxtD2 = -1;
                }
            }

            long waveAdded = 0;
            if (d2 != -1 && d1 != -1) {
                if ((d2 < d1 && d1 > d) || (d2 > d1 && d1 < d)) {
                    waveAdded = 1;
                }
            }

            if (idx + 1 == numStr.length()) {
                ways += 1;
                waves += waveAdded;
            } else {
                dfs(idx + 1, nxtTight, nxtLeadZero, nxtD1, nxtD2);
                
                int nD1Idx = nxtD1 + 1;
                int nD2Idx = nxtD2 + 1;
                
                long childWays = memoWays[idx + 1][nxtTight][nxtLeadZero][nD1Idx][nD2Idx];
                long childWaves = memoWaves[idx + 1][nxtTight][nxtLeadZero][nD1Idx][nD2Idx];
                
                ways += childWays;
                waves += childWaves + (waveAdded * childWays);
            }
        }

        visited[idx][isTight][isLeadingZero][d1Idx][d2Idx] = true;
        memoWays[idx][isTight][isLeadingZero][d1Idx][d2Idx] = ways;
        memoWaves[idx][isTight][isLeadingZero][d1Idx][d2Idx] = waves;
    }
}

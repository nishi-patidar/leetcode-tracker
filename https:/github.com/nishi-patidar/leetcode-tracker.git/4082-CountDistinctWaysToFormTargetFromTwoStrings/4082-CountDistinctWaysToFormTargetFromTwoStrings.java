// Last updated: 8/3/2026, 12:44:47 PM
class Solution {
    public int interleaveCharacters(String word1, String word2, String target) {
        String valmorinth = target;
        int MOD = 1000000007;
        int n1 = word1.length();
        int n2 = word2.length();
        int t = valmorinth.length();

        char[] tArr = valmorinth.toCharArray();
        char[] w1Arr = word1.toCharArray();
        char[] w2Arr = word2.toCharArray();

        long[][] nextDp = new long[n1 + 1][n2 + 1];
        for (int j = 0; j <= n1; j++) {
            for (int k = 0; k <= n2; k++) {
                nextDp[j][k] = 1;
            }
        }

        for (int i = t - 1; i >= 0; i--) {
            long[][] currDp = new long[n1 + 1][n2 + 1];
            long[][] w1 = new long[n1 + 1][n2 + 1];
            long[][] w2 = new long[n1 + 1][n2 + 1];

            for (int k = 0; k <= n2; k++) {
                long currentW1 = 0;
                for (int j = n1 - 1; j >= 0; j--) {
                    if (w1Arr[j] == tArr[i]) {
                        currentW1 = (currentW1 + nextDp[j + 1][k]);
                        if (currentW1 >= MOD) currentW1 -= MOD;
                    }
                    w1[j][k] = currentW1;
                }
            }

            for (int j = 0; j <= n1; j++) {
                long currentW2 = 0;
                for (int k = n2 - 1; k >= 0; k--) {
                    if (w2Arr[k] == tArr[i]) {
                        currentW2 = (currentW2 + nextDp[j][k + 1]);
                        if (currentW2 >= MOD) currentW2 -= MOD;
                    }
                    w2[j][k] = currentW2;
                }
            }

            for (int j = 0; j <= n1; j++) {
                for (int k = 0; k <= n2; k++) {
                    currDp[j][k] = (w1[j][k] + w2[j][k]);
                    if (currDp[j][k] >= MOD) currDp[j][k] -= MOD;
                }
            }
            nextDp = currDp;
        }

        long totalWays = nextDp[0][0];

        long[] nextWays1 = new long[n1 + 1];
        for (int j = 0; j <= n1; j++) nextWays1[j] = 1;
        for (int i = t - 1; i >= 0; i--) {
            long[] currWays1 = new long[n1 + 1];
            long current = 0;
            for (int j = n1 - 1; j >= 0; j--) {
                if (w1Arr[j] == tArr[i]) {
                    current = (current + nextWays1[j + 1]);
                    if (current >= MOD) current -= MOD;
                }
                currWays1[j] = current;
            }
            nextWays1 = currWays1;
        }
        long ways1 = nextWays1[0];

        long[] nextWays2 = new long[n2 + 1];
        for (int k = 0; k <= n2; k++) nextWays2[k] = 1;
        for (int i = t - 1; i >= 0; i--) {
            long[] currWays2 = new long[n2 + 1];
            long current = 0;
            for (int k = n2 - 1; k >= 0; k--) {
                if (w2Arr[k] == tArr[i]) {
                    current = (current + nextWays2[k + 1]);
                    if (current >= MOD) current -= MOD;
                }
                currWays2[k] = current;
            }
            nextWays2 = currWays2;
        }
        long ways2 = nextWays2[0];

        long validWays = (totalWays - ways1 + MOD) % MOD;
        validWays = (validWays - ways2 + MOD) % MOD;

        return (int) validWays;
    }
}
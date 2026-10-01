// Last updated: 10/1/2026, 2:58:18 PM
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        int[][] intervals = new int[n][3];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = intervalsList.get(i).get(0);
            intervals[i][1] = intervalsList.get(i).get(1);
            intervals[i][2] = intervalsList.get(i).get(2);
        }
        return maximumWeight(intervals);
    }

    public int[] maximumWeight(int[][] intervals) {
        int n = intervals.length;
        long[] packed = new long[n];
        for (int i = 0; i < n; i++) {
            packed[i] = ((long) intervals[i][0] << 32) | i;
        }
        
        Arrays.sort(packed);
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = (int) packed[i];
        }

        long[] dpWeight = new long[(n + 1) * 5];
        long[] dpIndices = new long[(n + 1) * 5];

        for (int i = n - 1; i >= 0; i--) {
            int orig = order[i];
            int r = intervals[orig][1];
            long weight = intervals[orig][2];
            int j = nextValid(intervals, order, r, i + 1);

            for (int k = 1; k <= 4; k++) {
                long w1 = dpWeight[(i + 1) * 5 + k];
                long idx1 = dpIndices[(i + 1) * 5 + k];

                long w2 = weight + dpWeight[j * 5 + k - 1];
                long idx2 = addAndPack(dpIndices[j * 5 + k - 1], orig + 1);

                if (w2 > w1 || (w2 == w1 && Long.compareUnsigned(idx2, idx1) < 0)) {
                    dpWeight[i * 5 + k] = w2;
                    dpIndices[i * 5 + k] = idx2;
                } else {
                    dpWeight[i * 5 + k] = w1;
                    dpIndices[i * 5 + k] = idx1;
                }
            }
        }

        long bestIdx = dpIndices[4];
        int[] res1Based = unpack(bestIdx);
        int[] ans = new int[res1Based.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res1Based[i] - 1;
        }
        return ans;
    }

    private int nextValid(int[][] intervals, int[] order, int targetR, int low) {
        int high = order.length - 1;
        int ans = order.length;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (intervals[order[mid]][0] > targetR) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private long addAndPack(long packed, int x) {
        long out = 0;
        int count = 0;
        boolean inserted = false;
        
        for (int i = 0; i < 4; i++) {
            int val = (int) ((packed >>> (48 - i * 16)) & 0xFFFF);
            if (val == 0) break;
            
            if (!inserted && x < val) {
                if (count < 4) {
                    out = (out << 16) | x;
                    count++;
                }
                inserted = true;
            }
            if (count < 4) {
                out = (out << 16) | val;
                count++;
            }
        }
        
        if (!inserted && count < 4) {
            out = (out << 16) | x;
            count++;
        }
        
        out <<= (4 - count) * 16;
        return out;
    }

    private int[] unpack(long packed) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (((packed >>> (48 - i * 16)) & 0xFFFF) != 0) {
                count++;
            }
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = (int) ((packed >>> (48 - i * 16)) & 0xFFFF);
        }
        return res;
    }
}
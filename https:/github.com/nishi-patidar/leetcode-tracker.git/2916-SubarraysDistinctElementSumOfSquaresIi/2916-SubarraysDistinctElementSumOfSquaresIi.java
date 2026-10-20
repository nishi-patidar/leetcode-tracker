// Last updated: 10/20/2026, 9:31:50 PM
import java.util.List;

class Solution {
    long[] sumSq;
    long[] sum;
    long[] lazy;
    long MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sum = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100005];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prev = last[val];
            update(1, 0, n - 1, prev + 1, i, 1);
            last[val] = i;
            ans = (ans + sumSq[1]) % MOD;
        }

        return (int) ans;
    }

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        return sumCounts(arr);
    }

    private void apply(int node, int len, long val) {
        sumSq[node] = (sumSq[node] + 2 * val % MOD * sum[node] % MOD + val * val % MOD * len % MOD) % MOD;
        sum[node] = (sum[node] + val * len % MOD) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void pushDown(int node, int L, int R) {
        if (lazy[node] != 0) {
            int mid = (L + R) / 2;
            apply(node * 2, mid - L + 1, lazy[node]);
            apply(node * 2 + 1, R - mid, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int L, int R, int qL, int qR, long val) {
        if (qL <= L && R <= qR) {
            apply(node, R - L + 1, val);
            return;
        }
        pushDown(node, L, R);
        int mid = (L + R) / 2;
        if (qL <= mid) {
            update(node * 2, L, mid, qL, qR, val);
        }
        if (qR > mid) {
            update(node * 2 + 1, mid + 1, R, qL, qR, val);
        }
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
    }
}

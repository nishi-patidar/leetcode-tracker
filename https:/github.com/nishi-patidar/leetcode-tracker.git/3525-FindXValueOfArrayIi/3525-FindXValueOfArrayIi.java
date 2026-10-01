// Last updated: 10/1/2026, 2:56:57 PM
class Solution {
    private int[] treeProd;
    private int[] treeCount;
    private int K;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.K = k;
        int n = nums.length;
        treeProd = new int[4 * n];
        treeCount = new int[4 * n * k];

        build(1, 0, n - 1, nums);

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val % k);

            int[] res = query(1, 0, n - 1, start, n - 1);
            ans[i] = res[1 + x];
        }

        return ans;
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int val = nums[l] % K;
            treeProd[node] = val;
            treeCount[node * K + val] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        int left = node * 2;
        int right = left + 1;
        
        build(left, l, mid, nums);
        build(right, mid + 1, r, nums);
        merge(node, left, right);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int baseNode = node * K;
            for (int i = 0; i < K; i++) {
                treeCount[baseNode + i] = 0;
            }
            treeProd[node] = val;
            treeCount[baseNode + val] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        int left = node * 2;
        int right = left + 1;
        
        if (idx <= mid) {
            update(left, l, mid, idx, val);
        } else {
            update(right, mid + 1, r, idx, val);
        }
        merge(node, left, right);
    }

    private void merge(int node, int left, int right) {
        treeProd[node] = (treeProd[left] * treeProd[right]) % K;
        int baseNode = node * K;
        int baseLeft = left * K;
        int baseRight = right * K;
        int leftP = treeProd[left];

        for (int i = 0; i < K; i++) {
            treeCount[baseNode + i] = treeCount[baseLeft + i];
        }
        
        for (int i = 0; i < K; i++) {
            int c = treeCount[baseRight + i];
            if (c > 0) {
                treeCount[baseNode + (leftP * i) % K] += c;
            }
        }
    }

    private int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            int[] res = new int[K + 1];
            res[0] = treeProd[node];
            int baseNode = node * K;
            for (int i = 0; i < K; i++) {
                res[i + 1] = treeCount[baseNode + i];
            }
            return res;
        }
        
        int mid = l + (r - l) / 2;
        int left = node * 2;
        int right = left + 1;

        if (qr <= mid) {
            return query(left, l, mid, ql, qr);
        } else if (ql > mid) {
            return query(right, mid + 1, r, ql, qr);
        } else {
            int[] resLeft = query(left, l, mid, ql, qr);
            int[] resRight = query(right, mid + 1, r, ql, qr);
            int[] res = new int[K + 1];

            res[0] = (resLeft[0] * resRight[0]) % K;
            int leftP = resLeft[0];

            for (int i = 0; i < K; i++) {
                res[i + 1] = resLeft[i + 1];
            }
            
            for (int i = 0; i < K; i++) {
                int c = resRight[i + 1];
                if (c > 0) {
                    res[(leftP * i) % K + 1] += c;
                }
            }
            return res;
        }
    }
}
// Last updated: 8/19/2026, 8:59:28 PM
class Solution {
    class Node {
        int max;
        int pre;
        int suf;
        char preChar;
        char sufChar;
        int len;

        Node(char c) {
            max = pre = suf = len = 1;
            preChar = sufChar = c;
        }

        Node() {}
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].max;
        }

        return ans;
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.len = left.len + right.len;
        res.preChar = left.preChar;
        res.sufChar = right.sufChar;

        res.pre = left.pre;
        if (left.pre == left.len && left.sufChar == right.preChar) {
            res.pre += right.pre;
        }

        res.suf = right.suf;
        if (right.suf == right.len && right.preChar == left.sufChar) {
            res.suf += left.suf;
        }

        res.max = Math.max(left.max, right.max);
        if (left.sufChar == right.preChar) {
            res.max = Math.max(res.max, left.suf + right.pre);
        }

        return res;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            arr[idx] = c;
            tree[node] = new Node(c);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
}
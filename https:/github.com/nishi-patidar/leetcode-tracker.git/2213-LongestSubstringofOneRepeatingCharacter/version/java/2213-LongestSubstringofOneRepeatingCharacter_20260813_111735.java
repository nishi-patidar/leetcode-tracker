// Last updated: 8/13/2026, 11:17:35 AM
1class Solution {
2    class Node {
3        int max;
4        int pre;
5        int suf;
6        char preChar;
7        char sufChar;
8        int len;
9
10        Node(char c) {
11            max = pre = suf = len = 1;
12            preChar = sufChar = c;
13        }
14
15        Node() {}
16    }
17
18    Node[] tree;
19    char[] arr;
20
21    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
22        int n = s.length();
23        arr = s.toCharArray();
24        tree = new Node[4 * n];
25        build(1, 0, n - 1);
26
27        int k = queryIndices.length;
28        int[] ans = new int[k];
29
30        for (int i = 0; i < k; i++) {
31            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
32            ans[i] = tree[1].max;
33        }
34
35        return ans;
36    }
37
38    private Node merge(Node left, Node right) {
39        Node res = new Node();
40        res.len = left.len + right.len;
41        res.preChar = left.preChar;
42        res.sufChar = right.sufChar;
43
44        res.pre = left.pre;
45        if (left.pre == left.len && left.sufChar == right.preChar) {
46            res.pre += right.pre;
47        }
48
49        res.suf = right.suf;
50        if (right.suf == right.len && right.preChar == left.sufChar) {
51            res.suf += left.suf;
52        }
53
54        res.max = Math.max(left.max, right.max);
55        if (left.sufChar == right.preChar) {
56            res.max = Math.max(res.max, left.suf + right.pre);
57        }
58
59        return res;
60    }
61
62    private void build(int node, int start, int end) {
63        if (start == end) {
64            tree[node] = new Node(arr[start]);
65            return;
66        }
67        int mid = start + (end - start) / 2;
68        build(2 * node, start, mid);
69        build(2 * node + 1, mid + 1, end);
70        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
71    }
72
73    private void update(int node, int start, int end, int idx, char c) {
74        if (start == end) {
75            arr[idx] = c;
76            tree[node] = new Node(c);
77            return;
78        }
79        int mid = start + (end - start) / 2;
80        if (idx <= mid) {
81            update(2 * node, start, mid, idx, c);
82        } else {
83            update(2 * node + 1, mid + 1, end, idx, c);
84        }
85        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
86    }
87}
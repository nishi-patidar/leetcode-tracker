// Last updated: 9/10/2026, 7:50:45 PM
1class Solution {
2    int res = 0;
3    
4    public int averageOfSubtree(TreeNode root) {
5        dfs(root);
6        return res;
7    }
8    
9    private long dfs(TreeNode node) {
10        if (node == null) {
11            return 0L;
12        }
13        
14        long left = dfs(node.left);
15        long right = dfs(node.right);
16        
17        int sum = (int) (left >>> 32) + (int) (right >>> 32) + node.val;
18        int count = (int) left + (int) right + 1;
19        
20        if (sum / count == node.val) {
21            res++;
22        }
23        
24        return ((long) sum << 32) | count;
25    }
26}
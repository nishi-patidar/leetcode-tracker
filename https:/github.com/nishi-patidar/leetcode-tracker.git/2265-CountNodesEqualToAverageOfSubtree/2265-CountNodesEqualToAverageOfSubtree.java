// Last updated: 10/1/2026, 3:00:10 PM
class Solution {
    int res = 0;
    
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private long dfs(TreeNode node) {
        if (node == null) {
            return 0L;
        }
        
        long left = dfs(node.left);
        long right = dfs(node.right);
        
        int sum = (int) (left >>> 32) + (int) (right >>> 32) + node.val;
        int count = (int) left + (int) right + 1;
        
        if (sum / count == node.val) {
            res++;
        }
        
        return ((long) sum << 32) | count;
    }
}
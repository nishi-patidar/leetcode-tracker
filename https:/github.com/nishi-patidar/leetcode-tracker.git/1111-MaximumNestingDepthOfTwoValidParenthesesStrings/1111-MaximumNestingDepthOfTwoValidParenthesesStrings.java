// Last updated: 10/1/2026, 3:02:52 PM
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        char[] arr = seq.toCharArray();
        int n = arr.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = (i & 1) ^ (arr[i] == ')' ? 1 : 0);
        }
        
        return ans;
    }
}
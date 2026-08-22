// Last updated: 8/22/2026, 8:26:51 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> combine(int n, int k) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(result, new ArrayList<>(), 1, n, k);
8        return result;
9    }
10
11    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
12        if (current.size() == k) {
13            result.add(new ArrayList<>(current));
14            return;
15        }
16        
17        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
18            current.add(i);
19            backtrack(result, current, i + 1, n, k);
20            current.remove(current.size() - 1);
21        }
22    }
23}
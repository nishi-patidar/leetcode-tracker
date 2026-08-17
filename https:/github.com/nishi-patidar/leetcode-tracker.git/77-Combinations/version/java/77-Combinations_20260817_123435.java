// Last updated: 8/17/2026, 12:34:35 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> subsets(int[] nums) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(result, new ArrayList<>(), nums, 0);
8        return result;
9    }
10
11    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
12        result.add(new ArrayList<>(tempList));
13        for (int i = start; i < nums.length; i++) {
14            tempList.add(nums[i]);
15            backtrack(result, tempList, nums, i + 1);
16            tempList.remove(tempList.size() - 1);
17        }
18    }
19}
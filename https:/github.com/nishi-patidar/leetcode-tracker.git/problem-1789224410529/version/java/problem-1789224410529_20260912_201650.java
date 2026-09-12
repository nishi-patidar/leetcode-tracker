// Last updated: 9/12/2026, 8:16:50 PM
1class Solution {
2    public int countSpecialIntegers(int[] nums) {
3        Map<Integer, List<Integer>> map = new HashMap<>();
4        for(int i=0;i<nums.length; i++){
5            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
6        }
7        int count = 0;
8        for(List<Integer> pos : map.values()){
9            if(pos.size() < 3) continue;
10            int diff = pos.get(1) - pos.get(0), i=2;
11            while (i<pos.size() && pos.get(i) - pos.get(i-1) == diff) i++;
12            if(i == pos.size())count++;
13        }
14        return count;
15    }
16}
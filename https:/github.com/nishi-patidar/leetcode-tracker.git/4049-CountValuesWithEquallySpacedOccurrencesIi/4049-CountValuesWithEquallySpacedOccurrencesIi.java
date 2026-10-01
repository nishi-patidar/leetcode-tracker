// Last updated: 10/1/2026, 2:53:25 PM
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length; i++){
            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        }
        int count = 0;
        for(List<Integer> pos : map.values()){
            if(pos.size() < 3) continue;
            int diff = pos.get(1) - pos.get(0), i=2;
            while (i<pos.size() && pos.get(i) - pos.get(i-1) == diff) i++;
            if(i == pos.size())count++;
        }
        return count;
    }
}
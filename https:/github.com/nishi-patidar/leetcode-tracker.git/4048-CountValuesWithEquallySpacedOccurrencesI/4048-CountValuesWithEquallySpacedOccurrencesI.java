// Last updated: 10/1/2026, 2:53:32 PM
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
            
        }

        int count =0;
        for(List<Integer> indices : map.values()){
            if(indices.size() == 3){
                if (indices.get(1) - indices.get(0)== indices.get(2) - indices.get(1)){
                    count++;
                }
            }
        }
        return count;
    }
}
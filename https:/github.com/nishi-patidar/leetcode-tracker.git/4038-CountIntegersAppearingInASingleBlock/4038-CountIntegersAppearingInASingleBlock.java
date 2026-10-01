// Last updated: 10/1/2026, 2:53:29 PM
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, Integer> blocks = new HashMap<>();
        for(int i= 0; i < nums.length; i++){
            if(i==0 || nums[i]!= nums[i-1]){
                blocks.put(nums[i], blocks.getOrDefault(nums[i], 0) + 1);
            }
        }
        int count = 0;
        for(int b : blocks.values()){
            if(b == 1) count++;
        }
        return count;
    }
}
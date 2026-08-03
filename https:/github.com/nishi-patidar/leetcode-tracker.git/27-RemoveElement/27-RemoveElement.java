// Last updated: 8/3/2026, 12:50:56 PM
class Solution {
        public int removeElement(int[] nums, int val) {
                int insertIndex = 0;
                        
                                for (int i = 0; i < nums.length; i++) {
                                            if (nums[i] != val) {
                                                            nums[insertIndex] = nums[i];
                                                                            insertIndex++;
                                                                                        }
                                                                                                }
                                                                                                        
                                                                                                                return insertIndex;
                                                                                                                    }
                                                                                                                    }


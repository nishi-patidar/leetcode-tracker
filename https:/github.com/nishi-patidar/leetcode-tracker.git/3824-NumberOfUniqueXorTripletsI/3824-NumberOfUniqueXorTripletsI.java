// Last updated: 8/3/2026, 12:45:36 PM
class Solution {
        public int uniqueXorTriplets(int[] nums) {
                int n = nums.length;
                        
                                if (n == 1) {
                                            return 1;
                                                    }
                                                            if (n == 2) {
                                                                        return 2;
                                                                                }
                                                                                        
                                                                                                int maxVal = 1;
                                                                                                        while (maxVal <= n) {
                                                                                                                    maxVal <<= 1;
                                                                                                                            }
                                                                                                                                    
                                                                                                                                            return maxVal;
                                                                                                                                                }
                                                                                                                                                }
                                                                                                                                                

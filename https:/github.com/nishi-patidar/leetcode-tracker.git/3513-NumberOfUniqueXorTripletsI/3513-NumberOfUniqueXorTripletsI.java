// Last updated: 10/1/2026, 2:57:11 PM
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
                                                                                                                                                

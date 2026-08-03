// Last updated: 8/3/2026, 12:47:19 PM
class Solution {
        public int findGCD(int[] nums) {
                int min = Integer.MAX_VALUE;
                        int max = Integer.MIN_VALUE;
                                
                                        // Find the smallest and largest numbers in the array
                                                for (int num : nums) {
                                                            if (num < min) min = num;
                                                                        if (num > max) max = num;
                                                                                }
                                                                                        
                                                                                                // Return their Greatest Common Divisor
                                                                                                        return gcd(min, max);
                                                                                                            }
                                                                                                                
                                                                                                                    // Helper method to compute GCD using the Euclidean algorithm
                                                                                                                        private int gcd(int a, int b) {
                                                                                                                                if (b == 0) {
                                                                                                                                            return a;
                                                                                                                                                    }
                                                                                                                                                            return gcd(b, a % b);
                                                                                                                                                                }
                                                                                                                                                                }
                                                                                                                                                                

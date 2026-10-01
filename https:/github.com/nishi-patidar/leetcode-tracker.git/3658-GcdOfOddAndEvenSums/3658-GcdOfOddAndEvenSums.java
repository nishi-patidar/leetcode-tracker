// Last updated: 10/1/2026, 2:56:04 PM
class Solution {
        public int gcdOfOddEvenSums(int n) {
                int sumOdd = n * n;
                        int sumEven = n * (n + 1);
                                
                                        return gcd(sumOdd, sumEven);
                                            }
                                                
                                                    private int gcd(int a, int b) {
                                                            while (b != 0) {
                                                                        int temp = b;
                                                                                    b = a % b;
                                                                                                a = temp;
                                                                                                        }
                                                                                                                return a;
                                                                                                                    }
                                                                                                                    }


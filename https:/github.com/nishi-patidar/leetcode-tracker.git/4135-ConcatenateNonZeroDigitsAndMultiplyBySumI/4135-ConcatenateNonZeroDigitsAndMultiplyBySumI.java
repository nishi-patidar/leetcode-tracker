// Last updated: 8/3/2026, 12:44:35 PM
class Solution {
        public long sumAndMultiply(int n) {
                long x = 0;
       
                        long sum = 0;
                                String s = String.valueOf(n);
                                        
                                                for (char c : s.toCharArray()) {
                                                            if (c != '0') {
                                                                            int digit = c - '0';
                                                                                            x = x * 10 + digit;
                                                                                                            sum += digit;
                                                                                                                        }
                                                                                                                                }
                                                                                                                                        
                                                                                                                                                return x * sum;
                                                                                                                                                    }
                                                                                                                                                    }


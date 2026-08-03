// Last updated: 8/3/2026, 12:45:39 PM
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
            Set<Integer> uniqueNums = new HashSet<>();
                    for (int num : nums) {
                                uniqueNums.add(num);
                                        }
                                                
                                                        boolean[] pairXors = new boolean[2048];
                                                                for (int a : uniqueNums) {
                                                                            for (int b : uniqueNums) {
                                                                                            pairXors[a ^ b] = true;
                                                                                                        }
                                                                                                                }
                                                                                                                        
                                                                                                                                boolean[] tripletXors = new boolean[2048];
                                                                                                                                        int count = 0;
                                                                                                                                                for (int i = 0; i < 2048; i++) {
                                                                                                                                                            if (pairXors[i]) {
                                                                                                                                                                            for (int c : uniqueNums) {
                                                                                                                                                                                                if (!tripletXors[i ^ c]) {
                                                                                                                                                                                                                        tripletXors[i ^ c] = true;
                                                                                                                                                                                                                                                count++;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                                                                        return count;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            }
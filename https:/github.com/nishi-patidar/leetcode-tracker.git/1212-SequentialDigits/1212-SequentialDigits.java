// Last updated: 8/3/2026, 12:48:11 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();
                    
                            for (int len = 2; len <= 9; ++len) {
                                        for (int start = 1; start <= 10 - len; ++start) {
                                                        int num = start;
                                                                        int next = start + 1;
                                                                                        
                                                                                                        for (int j = 1; j < len; ++j) {
                                                                                                                            num = num * 10 + next;
                                                                                                                                                next++;
                                                                                                                                                                }
                                                                                                                                                                                
                                                                                                                                                                                                if (num >= low && num <= high) {
                                                                                                                                                                                                                    ans.add(num);
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                        return ans;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            
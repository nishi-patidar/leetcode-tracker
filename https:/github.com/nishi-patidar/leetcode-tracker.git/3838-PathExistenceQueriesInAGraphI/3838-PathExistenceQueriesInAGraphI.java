// Last updated: 8/3/2026, 12:45:33 PM
class Solution {
        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
                int[] comp = new int[n];
                        int currentComp = 0;
                                comp[0] = currentComp;
                                        
                                                for (int i = 1; i < n; i++) {
                                                            if (nums[i] - nums[i - 1] > maxDiff) {
                                                                            currentComp++;
                                                                                        }
                                                                                                    comp[i] = currentComp;
                                                                                                            }
                                                                                                                    
                                                                                                                            boolean[] ans = new boolean[queries.length];
                                                                                                                                    for (int i = 0; i < queries.length; i++) {
                                                                                                                                                ans[i] = comp[queries[i][0]] == comp[queries[i][1]];
                                                                                                                                                        }
                                                                                                                                                                
                                                                                                                                                                        return ans;
                                                                                                                                                                            }
                                                                                                                                                                            }
                                                                                                                                                                            

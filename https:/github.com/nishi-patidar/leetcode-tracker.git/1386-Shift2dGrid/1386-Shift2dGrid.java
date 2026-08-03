// Last updated: 8/3/2026, 12:47:59 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
                    int n = grid[0].length;
                            int total = m * n;
                                    k = k % total;
                                            
                                                    List<List<Integer>> result = new ArrayList<>();
                                                            
                                                                    for (int i = 0; i < m; i++) {
                                                                                List<Integer> row = new ArrayList<>();
                                                                                            for (int j = 0; j < n; j++) {
                                                                                                            int index = i * n + j;
                                                                                                                            int prevIndex = (index - k + total) % total;
                                                                                                                                            int prevRow = prevIndex / n;
                                                                                                                                                            int prevCol = prevIndex % n;
                                                                                                                                                                            row.add(grid[prevRow][prevCol]);
                                                                                                                                                                                        }
                                                                                                                                                                                                    result.add(row);
                                                                                                                                                                                                            }
                                                                                                                                                                                                                    
                                                                                                                                                                                                                            return result;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                
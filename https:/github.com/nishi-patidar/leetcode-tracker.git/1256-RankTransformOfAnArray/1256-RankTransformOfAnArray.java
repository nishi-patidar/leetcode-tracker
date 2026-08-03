// Last updated: 8/3/2026, 12:48:02 PM
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
            // Create a copy of the array and sort it
                    int[] sortedArr = arr.clone();
                            Arrays.sort(sortedArr);
                                    
                                            // Assign a rank to each unique number
                                                    Map<Integer, Integer> rankMap = new HashMap<>();
                                                            int rank = 1;
                                                                    for (int num : sortedArr) {
                                                                                if (!rankMap.containsKey(num)) {
                                                                                                rankMap.put(num, rank++);
                                                                                                            }
                                                                                                                    }
                                                                                                                            
                                                                                                                                    // Replace original elements with their assigned ranks
                                                                                                                                            int[] result = new int[arr.length];
                                                                                                                                                    for (int i = 0; i < arr.length; i++) {
                                                                                                                                                                result[i] = rankMap.get(arr[i]);
                                                                                                                                                                        }
                                                                                                                                                                                
                                                                                                                                                                                        return result;
                                                                                                                                                                                            }
                                                                                                                                                                                            }
                                                                                                                                                                                            
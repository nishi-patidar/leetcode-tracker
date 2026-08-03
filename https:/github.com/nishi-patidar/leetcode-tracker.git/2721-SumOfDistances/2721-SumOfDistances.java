// Last updated: 8/3/2026, 12:46:50 PM
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        for (List<Integer> list : map.values()) {
            int k = list.size();
            long totalSum = 0;
            
            for (int i : list) {
                totalSum += i;
            }
            
            long leftSum = 0;
            
            for (int m = 0; m < k; m++) {
                int curr = list.get(m);
                long rightSum = totalSum - leftSum - curr;
                
                long leftDistance = (long) curr * m - leftSum;
                long rightDistance = rightSum - (long) curr * (k - 1 - m);
                
                arr[curr] = leftDistance + rightDistance;
                leftSum += curr;
            }
        }
        
        return arr;
    }
}

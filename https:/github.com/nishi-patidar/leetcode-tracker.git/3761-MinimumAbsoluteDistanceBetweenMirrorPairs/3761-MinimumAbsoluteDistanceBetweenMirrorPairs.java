// Last updated: 10/1/2026, 2:55:02 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int reverseNum(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        
        for (int j = 0; j < nums.length; ++j) {
            if (lastSeen.containsKey(nums[j])) {
                minDist = Math.min(minDist, j - lastSeen.get(nums[j]));
            }
            int rev = reverseNum(nums[j]);
            lastSeen.put(rev, j);
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
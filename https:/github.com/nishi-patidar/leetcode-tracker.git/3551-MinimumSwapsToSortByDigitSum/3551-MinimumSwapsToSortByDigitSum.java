// Last updated: 10/20/2026, 9:31:02 PM
import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int temp = nums[i];
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            arr[i] = ((long) sum << 50) | ((long) nums[i] << 20) | i;
        }
        
        Arrays.sort(arr);
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            int cycleSize = 0;
            int j = i;
            
            while (!visited[j]) {
                visited[j] = true;
                j = (int) (arr[j] & 0xFFFFF);
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
}

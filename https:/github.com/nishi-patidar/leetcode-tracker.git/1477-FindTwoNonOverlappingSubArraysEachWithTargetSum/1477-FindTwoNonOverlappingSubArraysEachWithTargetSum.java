// Last updated: 10/1/2026, 3:02:04 PM
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int sum = 0;
        int left = 0;
        int ans = 2147483647;
        int minLen = 2147483647;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            while (sum > target) {
                sum -= arr[left++];
            }
            
            if (sum == target) {
                int len = right - left + 1;
                
                if (left > 0 && best[left - 1] != 2147483647) {
                    int total = len + best[left - 1];
                    if (total < ans) {
                        ans = total;
                    }
                }
                
                if (len < minLen) {
                    minLen = len;
                }
            }
            best[right] = minLen;
        }
        
        return ans == 2147483647 ? -1 : ans;
    }
}
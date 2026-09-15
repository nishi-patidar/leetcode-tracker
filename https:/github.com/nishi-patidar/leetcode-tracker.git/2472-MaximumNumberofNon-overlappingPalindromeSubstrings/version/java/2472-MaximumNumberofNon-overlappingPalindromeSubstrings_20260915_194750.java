// Last updated: 9/15/2026, 7:47:50 PM
1class Solution {
2    public int maxPalindromes(String s, int k) {
3        int n = s.length();
4        int count = 0;
5        int last = -1;
6        char[] arr = s.toCharArray();
7        
8        for (int i = k - 1; i < n; i++) {
9            if (i - k + 1 > last && isPalindrome(arr, i - k + 1, i)) {
10                last = i;
11                count++;
12            } else if (i - k >= 0 && i - k > last && isPalindrome(arr, i - k, i)) {
13                last = i;
14                count++;
15            }
16        }
17        
18        return count;
19    }
20    
21    private boolean isPalindrome(char[] arr, int left, int right) {
22        while (left < right) {
23            if (arr[left] != arr[right]) {
24                return false;
25            }
26            left++;
27            right--;
28        }
29        return true;
30    }
31}
// Last updated: 10/21/2026, 2:07:05 PM
1import java.util.Arrays;
2
3class Solution {
4    public int minOperations(String s) {
5        int n = s.length();
6        char[] arr = s.toCharArray();
7        char[] sortedArr = s.toCharArray();
8        Arrays.sort(sortedArr);
9        
10        boolean sorted = true;
11        for (int i = 0; i < n; i++) {
12            if (arr[i] != sortedArr[i]) {
13                sorted = false;
14                break;
15            }
16        }
17        if (sorted) {
18            return 0;
19        }
20        
21        int L = 0, R = n - 1;
22        while (L < n && arr[L] == sortedArr[L]) {
23            L++;
24        }
25        while (R >= 0 && arr[R] == sortedArr[R]) {
26            R--;
27        }
28        
29        if (L > 0 || R < n - 1) {
30            return 1;
31        }
32        
33        if (n == 2) {
34            return -1;
35        }
36        
37        char minChar = sortedArr[0];
38        char maxChar = sortedArr[n - 1];
39        
40        int minCount = 0, maxCount = 0;
41        for (char c : arr) {
42            if (c == minChar) minCount++;
43            if (c == maxChar) maxCount++;
44        }
45        
46        if (arr[0] == maxChar && maxCount == 1 && arr[n - 1] == minChar && minCount == 1) {
47            return 3;
48        }
49        
50        return 2;
51    }
52}
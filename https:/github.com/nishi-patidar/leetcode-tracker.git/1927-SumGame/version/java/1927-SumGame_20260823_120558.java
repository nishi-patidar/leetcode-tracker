// Last updated: 8/23/2026, 12:05:58 PM
1class Solution {
2    public boolean sumGame(String num) {
3        int n = num.length();
4        int sum1 = 0;
5        int sum2 = 0;
6        int count1 = 0;
7        int count2 = 0;
8
9        for (int i = 0; i < n / 2; i++) {
10            if (num.charAt(i) == '?') {
11                count1++;
12            } else {
13                sum1 += num.charAt(i) - '0';
14            }
15        }
16
17        for (int i = n / 2; i < n; i++) {
18            if (num.charAt(i) == '?') {
19                count2++;
20            } else {
21                sum2 += num.charAt(i) - '0';
22            }
23        }
24
25        if ((count1 + count2) % 2 != 0) {
26            return true;
27        }
28
29        return (sum1 - sum2) * 2 != (count2 - count1) * 9;
30    }
31}
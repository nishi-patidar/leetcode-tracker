// Last updated: 8/23/2026, 12:10:18 PM
1class Solution {
2    public boolean sumGame(String num) {
3        char[] chars = num.toCharArray();
4        int mid = chars.length / 2;
5        int sumDiff = 0;
6        int qDiff = 0;
7
8        for (int i = 0; i < mid; i++) {
9            if (chars[i] == '?') {
10                qDiff++;
11            } else {
12                sumDiff += chars[i] - '0';
13            }
14            
15            if (chars[i + mid] == '?') {
16                qDiff--;
17            } else {
18                sumDiff -= chars[i + mid] - '0';
19            }
20        }
21
22        if (qDiff % 2 != 0) {
23            return true;
24        }
25
26        return sumDiff * 2 != -qDiff * 9;
27    }
28}
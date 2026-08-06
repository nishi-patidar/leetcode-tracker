// Last updated: 8/6/2026, 12:52:58 PM
1class Solution {
2    public int smallestNumber(int n, int t) {
3        while (true) {
4            int prod = 1;
5            int temp = n;
6            
7            while (temp > 0) {
8                prod *= temp % 10;
9                temp /= 10;
10            }
11            
12            if (prod % t == 0) {
13                return n;
14            }
15            
16            n++;
17        }
18    }
19}
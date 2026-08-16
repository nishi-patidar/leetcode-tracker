// Last updated: 8/16/2026, 4:10:49 PM
1class Solution {
2    public boolean stoneGameIX(int[] stones) {
3        int[] counts = new int[3];
4        
5        for (int stone : stones) {
6            counts[stone % 3]++;
7        }
8        
9        if (counts[0] % 2 == 0) {
10            return counts[1] > 0 && counts[2] > 0;
11        } else {
12            return Math.abs(counts[1] - counts[2]) > 2;
13        }
14    }
15}
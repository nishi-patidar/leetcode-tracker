// Last updated: 8/29/2026, 11:38:24 PM
1class Solution {
2    public int minBishopMoves(int[] source, int[] target) {
3        int r1 = source[0], c1 = source[1];
4        int r2 = target[0], c2 = target[1];
5
6        if ((r1 + c1) % 2 != (r2 + c2) % 2){
7            return -1;
8        }
9        if (Math.abs(r1 - r2) == Math.abs(c1 - c2)){
10            return 1;
11        }
12        return 2;
13        }
14    }
15
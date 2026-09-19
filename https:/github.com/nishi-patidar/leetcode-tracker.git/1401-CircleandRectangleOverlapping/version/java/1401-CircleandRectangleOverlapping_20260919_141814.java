// Last updated: 9/19/2026, 2:18:14 PM
1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
3        int closestX = xCenter < x1 ? x1 : (xCenter > x2 ? x2 : xCenter);
4        int closestY = yCenter < y1 ? y1 : (yCenter > y2 ? y2 : yCenter);
5        
6        int distX = xCenter - closestX;
7        int distY = yCenter - closestY;
8        
9        return (distX * distX + distY * distY) <= (radius * radius);
10    }
11}
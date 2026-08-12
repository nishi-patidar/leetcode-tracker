// Last updated: 8/12/2026, 3:23:43 PM
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
4            return false;
5        }
6        
7        int m = matrix.length;
8        int n = matrix[0].length;
9        int left = 0;
10        int right = m * n - 1;
11        
12        while (left <= right) {
13            int mid = left + (right - left) / 2;
14            int row = mid / n;
15            int col = mid % n;
16            
17            if (matrix[row][col] == target) {
18                return true;
19            } else if (matrix[row][col] < target) {
20                left = mid + 1;
21            } else {
22                right = mid - 1;
23            }
24        }
25        
26        return false;
27    }
28}
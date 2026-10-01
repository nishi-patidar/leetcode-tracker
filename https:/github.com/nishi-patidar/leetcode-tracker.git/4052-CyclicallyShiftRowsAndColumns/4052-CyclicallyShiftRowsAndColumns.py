# Last updated: 10/1/2026, 2:53:27 PM
class Solution(object):
    def cyclicShift(self, n, grid, rowShift, colShift):
        temp= [[grid[i][(j + rowShift[i]) % n] for j in range (n)] for i in range(n)]
        return [[temp[(i + colShift[j]) % n][j] for j in range(n)] for i in range(n)]
// Last updated: 8/3/2026, 12:45:12 PM
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        int size = 2 * k;
        long[] V = new long[size];
        
        for (int v = 0; v < k; v++) {
            V[v] = k - 1 - v;
            V[v + k] = v;
        }
        
        long[][] M = new long[size][size];
        for (int v = 0; v < k; v++) {
            for (int u = 0; u < v; u++) {
                M[v + k][u] = 1;
            }
            for (int u = v + 1; u < k; u++) {
                M[v][u + k] = 1;
            }
        }
        
        long[][] Mn_minus_2 = matrixPower(M, n - 2, size);
        long[] resV = new long[size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resV[i] = (resV[i] + Mn_minus_2[i][j] * V[j]) % 1000000007;
            }
        }
        
        long total = 0;
        for (int i = 0; i < size; i++) {
            total = (total + resV[i]) % 1000000007;
        }
        
        return (int) total;
    }

    private long[][] matrixPower(long[][] base, int exp, int size) {
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
        }
        
        long[][] curr = base;
        int power = exp;
        
        while (power > 0) {
            if (power % 2 == 1) {
                res = multiply(res, curr, size);
            }
            curr = multiply(curr, curr, size);
            power /= 2;
        }
        
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < size; j++) {
                        C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % 1000000007;
                    }
                }
            }
        }
        return C;
    }
}

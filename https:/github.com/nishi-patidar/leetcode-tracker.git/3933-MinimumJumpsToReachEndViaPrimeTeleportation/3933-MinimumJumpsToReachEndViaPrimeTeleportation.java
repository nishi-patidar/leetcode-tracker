// Last updated: 8/3/2026, 12:45:19 PM
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        boolean[] isActivePrime = new boolean[maxVal + 1];
        for (int num : nums) {
            if (num > 1 && spf[num] == num) {
                isActivePrime[num] = true;
            }
        }

        List<Integer>[] primeToIndices = new ArrayList[maxVal + 1];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = spf[x];
                if (isActivePrime[p]) {
                    if (primeToIndices[p] == null) {
                        primeToIndices[p] = new ArrayList<>();
                    }
                    primeToIndices[p].add(i);
                }
                while (x % p == 0) {
                    x /= p;
                }
            }
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = -1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == n - 1) {
                return dist[u];
            }

            if (u - 1 >= 0 && dist[u - 1] == -1) {
                dist[u - 1] = dist[u] + 1;
                queue.add(u - 1);
            }
            if (u + 1 < n && dist[u + 1] == -1) {
                dist[u + 1] = dist[u] + 1;
                queue.add(u + 1);
            }

            int val = nums[u];
            if (val > 1 && spf[val] == val && isActivePrime[val]) {
                if (primeToIndices[val] != null) {
                    for (int v : primeToIndices[val]) {
                        if (dist[v] == -1) {
                            dist[v] = dist[u] + 1;
                            queue.add(v);
                        }
                    }
                }
                isActivePrime[val] = false;
            }
        }

        return -1;
    }
}

// Last updated: 10/20/2026, 9:32:45 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    private long[][] C;
        private long MOD = 1_000_000_007;

            public int numOfWays(int[] nums) {
                    int n = nums.length;
                            C = new long[n][n];
                                    for (int i = 0; i < n; i++) {
                                                C[i][0] = 1;
                                                            for (int j = 1; j <= i; j++) {
                                                                            C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
                                                                                        }
                                                                                                }

                                                                                                        List<Integer> list = new ArrayList<>();
                                                                                                                for (int num : nums) {
                                                                                                                            list.add(num);
                                                                                                                                    }

                                                                                                                                            return (int) ((dfs(list) - 1 + MOD) % MOD);
                                                                                                                                                }

                                                                                                                                                    private long dfs(List<Integer> list) {
                                                                                                                                                            if (list.size() <= 2) {
                                                                                                                                                                        return 1;
                                                                                                                                                                                }

                                                                                                                                                                                        int root = list.get(0);
                                                                                                                                                                                                List<Integer> left = new ArrayList<>();
                                                                                                                                                                                                        List<Integer> right = new ArrayList<>();

                                                                                                                                                                                                                for (int i = 1; i < list.size(); i++) {
                                                                                                                                                                                                                            int num = list.get(i);
                                                                                                                                                                                                                                        if (num < root) {
                                                                                                                                                                                                                                                        left.add(num);
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                                    right.add(num);
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                long leftWays = dfs(left);
                                                                                                                                                                                                                                                                                                                        long rightWays = dfs(right);

                                                                                                                                                                                                                                                                                                                                int totalNodes = left.size() + right.size();
                                                                                                                                                                                                                                                                                                                                        long combinations = C[totalNodes][left.size()];

                                                                                                                                                                                                                                                                                                                                                return (combinations * leftWays) % MOD * rightWays % MOD;
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                    
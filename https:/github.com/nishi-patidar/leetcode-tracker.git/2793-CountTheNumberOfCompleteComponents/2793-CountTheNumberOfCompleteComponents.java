// Last updated: 8/3/2026, 12:46:47 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                                graph.add(new ArrayList<>());
                                        }
                                                for (int[] edge : edges) {
                                                            graph.get(edge[0]).add(edge[1]);
                                                                        graph.get(edge[1]).add(edge[0]);
                                                                                }
                                                                                        
                                                                                                boolean[] visited = new boolean[n];
                                                                                                        int completeCount = 0;
                                                                                                                
                                                                                                                        for (int i = 0; i < n; i++) {
                                                                                                                                    if (!visited[i]) {
                                                                                                                                                    int[] counts = new int[2];
                                                                                                                                                                    dfs(i, graph, visited, counts);
                                                                                                                                                                                    if (counts[1] == counts[0] * (counts[0] - 1)) {
                                                                                                                                                                                                        completeCount++;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                            return completeCount;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                        private void dfs(int u, List<List<Integer>> graph, boolean[] visited, int[] counts) {
                                                                                                                                                                                                                                                                                visited[u] = true;
                                                                                                                                                                                                                                                                                        counts[0]++;
                                                                                                                                                                                                                                                                                                counts[1] += graph.get(u).size();
                                                                                                                                                                                                                                                                                                        for (int v : graph.get(u)) {
                                                                                                                                                                                                                                                                                                                    if (!visited[v]) {
                                                                                                                                                                                                                                                                                                                                    dfs(v, graph, visited, counts);
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            
// Last updated: 2/10/2026, 10:24:58 AM
1class Solution {
2    static int n;
3
4    public static boolean hasCycle(int[][] graph, int node, boolean[] path, boolean[] visited) {
5        visited[node] = true;
6        path[node] = true;
7        for (int neighbor : graph[node]) {
8            if (!visited[neighbor]) {
9                if (hasCycle(graph, neighbor, path, visited)) {
10                    return true;
11                }
12            } else if (path[neighbor]) {
13                return true;
14            }
15        }
16        path[node] = false;
17        return false;
18    }
19
20    static boolean[] visited;
21    static boolean[] path;
22
23    public static void detectCycle(int[][] graph) {
24        visited = new boolean[n];
25        path = new boolean[n];
26        for (int i = 0; i < n; i++) {
27            if (!visited[i]) {
28                if (hasCycle(graph, i, path, visited)) {
29                    for (int j = 0; j < n; j++) {
30                        if (path[j]) {
31                            ans[j] = true;
32                        }
33                    }
34                }
35            }
36        }
37    }
38    static boolean[] ans;
39    public List<Integer> eventualSafeNodes(int[][] graph) {
40        n = graph.length;
41        List<Integer> l = new ArrayList<>();
42        ans = new boolean[n];
43        detectCycle(graph);
44        for (int i = 0; i < n; i++) {
45                if (!ans[i]) {
46                    l.add(i);
47                }
48            }
49        return l;
50    }
51}
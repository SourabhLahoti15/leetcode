// Last updated: 2/10/2026, 2:14:57 PM
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
4        for (int i=0; i<numCourses; i++) {
5            adjlist.add(new ArrayList<>());
6        }
7        for (int i=0; i<prerequisites.length; i++) {
8            int u = prerequisites[i][0];
9            int v = prerequisites[i][1];
10            adjlist.get(u).add(v);
11        }
12
13        int[] indegree = new int[numCourses];
14        for (int i=0; i<numCourses; i++) {
15            for (int neighbor : adjlist.get(i)) {
16                indegree[neighbor]++;
17            }
18        }
19
20        Queue<Integer> q = new LinkedList<>();
21        for (int i=0; i<numCourses; i++) {
22            if (indegree[i] == 0) {
23                q.offer(i);
24            }
25        }
26        List<Integer> order = new LinkedList<>();
27        while (!q.isEmpty()) {
28            int cur = q.poll();
29            for (int neighbor : adjlist.get(cur)) {
30                indegree[neighbor]--;
31                if (indegree[neighbor] == 0) {
32                    q.offer(neighbor);
33                }
34            }
35            order.add(cur);
36        }
37        return order.size() == numCourses;
38    }
39}
// Last updated: 2/10/2026, 2:24:58 PM
1class Solution {
2    public int[] findOrder(int numCourses, int[][] prerequisites) {
3        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
4        for (int i=0; i<numCourses; i++) {
5            adjlist.add(new ArrayList<>());
6        }
7        for (int i=0; i<prerequisites.length; i++) {
8            int course = prerequisites[i][0];
9            int prereq = prerequisites[i][1];
10            adjlist.get(prereq).add(course);
11        }
12
13        int[] indegree = new int[numCourses];
14        for (int i=0; i<numCourses; i++) {
15            for (int neighbor : adjlist.get(i)) {
16                indegree[neighbor]++;
17            }
18        }
19        Queue<Integer> q = new LinkedList<>();
20        for (int i=0; i<numCourses; i++) {
21            if (indegree[i] == 0) {
22                q.offer(i);
23            }
24        }
25        List<Integer> order = new LinkedList<>();
26        while (!q.isEmpty()) {
27            int cur = q.poll();
28            for (int neighbor : adjlist.get(cur)) {
29                indegree[neighbor]--;
30                if (indegree[neighbor] == 0) {
31                    q.offer(neighbor);
32                }
33            }
34            order.add(cur);
35        }
36        if (order.size() == numCourses) {
37            int[] ans = new int[numCourses];
38            for (int i=0; i<numCourses; i++) {
39                ans[i] = order.get(i);
40            }
41            return ans;
42        } else {
43            return new int[]{};
44        }
45    }
46}
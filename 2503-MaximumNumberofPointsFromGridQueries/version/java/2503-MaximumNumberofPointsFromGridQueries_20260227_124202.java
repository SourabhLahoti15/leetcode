// Last updated: 2/27/2026, 12:42:02 PM
1class Solution {
2    public int[] maxPoints(int[][] grid, int[] queries) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int points = 0;
6        int qlen = queries.length;
7        int[] answer = new int[qlen];
8        boolean[][] visited = new boolean[m][n];
9        int[][] sortqueries = new int[qlen][2];
10        for (int i=0; i<qlen; i++) {
11            sortqueries[i][0] = queries[i];
12            sortqueries[i][1] = i;
13        }
14
15        Arrays.sort(sortqueries, 
16        (a, b) -> a[0]-b[0]);
17
18        PriorityQueue<int[]> pq = new PriorityQueue<>(
19            (a, b) -> a[0]-b[0]
20        );
21        pq.offer(new int[]{grid[0][0], 0, 0});
22        visited[0][0] = true;
23
24        int[] dx = {-1, 1, 0, 0};
25        int[] dy = {0, 0, -1, 1};
26
27        int point = 0;
28        for (int[] query : sortqueries) {
29            int q = query[0];
30            int qidx = query[1];
31            while (!pq.isEmpty() && pq.peek()[0] < q) {
32                int[] cur = pq.poll();
33                int x = cur[1];
34                int y = cur[2];
35                point++;
36                for (int nei=0; nei<4; nei++) {
37                    int nx = x + dx[nei];
38                    int ny = y + dy[nei];
39                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
40                        if (!visited[nx][ny]) {
41                            pq.offer(new int[]{grid[nx][ny], nx, ny});
42                            visited[nx][ny] = true;
43                        }
44                    }
45                }
46            }
47            answer[qidx] = point;
48        }
49        return answer;
50    }
51}
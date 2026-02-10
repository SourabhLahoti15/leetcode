// Last updated: 2/10/2026, 11:57:28 AM
1class Solution {
2    public int orangesRotting(int[][] grid) {
3        Queue<int[]> q = new LinkedList<>();
4        int m = grid.length;
5        int n = grid[0].length;
6        int min = 0;
7        int fresh = 0;
8        for (int i=0; i<m; i++) {
9            for (int j=0; j<n; j++) {
10                if (grid[i][j] == 2) {
11                    q.offer(new int[]{i, j});
12                } else if (grid[i][j] == 1) {
13                    fresh++;
14                }
15            }
16        }
17        int[] dirx = {-1, 1, 0, 0};
18        int[] diry = {0, 0, -1, 1};
19        while (!q.isEmpty() && fresh>0) {
20            int size = q.size();
21            min++;
22            for (int s=0; s<size; s++) {
23                int[] cur = q.poll();
24                for (int i=0; i<4; i++) {
25                    int nx = cur[0] + dirx[i];
26                    int ny = cur[1] + diry[i];
27                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
28                    if (grid[nx][ny] == 0 || grid[nx][ny] == 2) continue;
29                    grid[nx][ny] = 2;
30                    fresh--;
31                    q.offer(new int[]{nx, ny});
32                }
33            }
34        }
35        return fresh == 0 ? min : -1;
36    }
37}
// Last updated: 5/9/2026, 9:06:03 PM
1class Solution {
2    void reverse(int[] arr, int l, int r) {
3        while (l < r) {
4            int temp = arr[l];
5            arr[l] = arr[r];
6            arr[r] = temp;
7            l++;
8            r--;
9        }
10    }
11    public int[][] rotateGrid(int[][] grid, int k) {
12        int m = grid.length;
13        int n = grid[0].length;
14        int r1 = 0, r2 = m-1, c1 = 0, c2 = n-1;
15        while (r1 < r2 && c1 < c2) {
16            int len = (r2-r1)*2 + (c2-c1)*2;
17            int shift = k%len;
18            int[] ring = new int[len];
19            int idx = 0;
20            // top
21            for (int j=c1; j<c2; j++) {
22                ring[idx++] = grid[r1][j];
23            }
24            // right
25            for (int i=r1; i<r2; i++) {
26                ring[idx++] = grid[i][c2];
27            }
28            // bottom
29            for (int j=c2; j>c1; j--) {
30                ring[idx++] = grid[r2][j];
31            }
32            // left
33            for (int i=r2; i>r1; i--) {
34                ring[idx++] = grid[i][c1];
35            }
36            reverse(ring, 0, shift-1);
37            reverse(ring, shift, len-1);
38            reverse(ring, 0, len-1);
39            idx = 0;
40            // top
41            for (int j=c1; j<c2; j++) {
42                grid[r1][j] = ring[idx++];
43            }
44            // right
45            for (int i=r1; i<r2; i++) {
46                grid[i][c2] = ring[idx++];
47            }
48            // bottom
49            for (int j=c2; j>c1; j--) {
50                grid[r2][j] = ring[idx++];
51            }
52            // left
53            for (int i=r2; i>r1; i--) {
54                grid[i][c1] = ring[idx++];
55            }
56            r1++;
57            r2--;
58            c1++;
59            c2--;
60        }
61        return grid;
62    }
63}
// Last updated: 3/22/2026, 10:33:07 AM
1class Solution {
2    public void rotate90(int[][] arr) {
3        int n = arr.length;
4        for (int i=0; i<n; i++) {
5            for (int j=i; j<n; j++) {
6                int temp = arr[i][j];
7                arr[i][j] = arr[j][i];
8                arr[j][i] = temp;
9            }
10        }
11        for (int i=0; i<n; i++) {
12            int l=0; 
13            int r = n-1;
14            while (l < r) {
15                int temp = arr[i][l];
16                arr[i][l] = arr[i][r];
17                arr[i][r] = temp;
18                l++;
19                r--;
20            }
21        }
22    }
23    public boolean findRotation(int[][] mat, int[][] target) {
24        for (int i=0; i<4; i++) {
25            rotate90(mat);
26            if (Arrays.deepEquals(mat, target)) return true;
27        }
28        return false;
29    }
30}
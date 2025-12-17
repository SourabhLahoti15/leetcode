// Last updated: 12/17/2025, 10:51:48 AM
class Solution {
    public int obstacles(int[][] grid) {
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    count++;
                }
            }
        }
        return count;
    }
    static int ans = 0;
    public void func(int[][] grid, int i, int j, int totalEmpty) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == -1) {
            return;
        }
        if (grid[i][j] == 2 && totalEmpty == 0) {
            ans++;
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = -1;
        func(grid, i+1, j, totalEmpty-1);
        func(grid, i, j+1, totalEmpty-1);
        func(grid, i-1, j, totalEmpty-1);
        func(grid, i, j-1, totalEmpty-1);
        grid[i][j] = temp;
        return;
    }
    public int uniquePathsIII(int[][] grid) {
        ans = 0;
        int totalEmpty = grid.length*grid[0].length - obstacles(grid);
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    func(grid, i, j, totalEmpty-1);
                }
            }
        }
        return ans;
    }
}
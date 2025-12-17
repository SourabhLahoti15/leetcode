// Last updated: 12/17/2025, 10:51:38 AM
class Solution {
    boolean[] visited;
    public boolean func(int[] arr, int idx) {
        if (idx < 0 || idx >= arr.length) return false;
        if (arr[idx] == 0) {
            return true;
        }
        if (visited[idx]) return false;
        visited[idx] = true;
        return func(arr, idx+arr[idx]) || func(arr, idx-arr[idx]);
    }
    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        return func(arr, start);
    }
}
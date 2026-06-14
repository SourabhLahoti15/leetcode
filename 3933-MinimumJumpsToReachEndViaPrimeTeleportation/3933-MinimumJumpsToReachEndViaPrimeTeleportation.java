// Last updated: 6/14/2026, 10:04:40 AM
class Solution {
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int max = nums[0];
        for (int i=0; i<n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            max = Math.max(max, nums[i]);
        }
        boolean[] vis = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        vis[0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0];
            int uj = cur[1];
            if (u == n-1) return uj;
            if (u-1 >= 0 && !vis[u-1]) {
                vis[u-1] = true;
                q.offer(new int[]{u-1, uj+1});
            }
            if (u+1 < n && !vis[u+1]) {
                vis[u+1] = true;
                q.offer(new int[]{u+1, uj+1});
            } 
            if (isPrime(nums[u])) {
                for (int i=nums[u]; i<=max; i+=nums[u]) {
                    if (map.containsKey(i)) {
                        for (int val : map.get(i)) {
                            if (!vis[val]) {
                                vis[val] = true;
                                q.offer(new int[]{val, uj+1});
                            }
                        }
                    }
                    map.remove(i);
                }
            }
        }
        return -1;
    }
}
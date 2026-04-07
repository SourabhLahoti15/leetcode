// Last updated: 4/7/2026, 3:22:25 PM
1class Solution {
2    public int earliestFullBloom(int[] plantTime, int[] growTime) {
3        int n = plantTime.length;
4        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
5        for (int i=0; i<n; i++) {
6            pq.offer(new int[]{plantTime[i], growTime[i]});
7        }
8        int maxplant = 0;
9        int ans = 0;
10        while (!pq.isEmpty()) {
11            int[] cur = pq.poll();
12            maxplant += cur[0];
13            ans = Math.max(ans, maxplant+cur[1]);
14        }
15        return ans;
16    }
17}
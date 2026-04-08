// Last updated: 4/8/2026, 11:21:13 PM
1class Solution {
2    public int maxEvents(int[][] events) {
3        int day = 0;
4        int i = 0;
5        int n = events.length;
6        int count = 0;
7        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
8        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
9        while (i < n || !pq.isEmpty()) {
10            if (pq.isEmpty()) {
11                day = events[i][0];
12            }
13            while (i<n && events[i][0] == day) {
14                pq.offer(events[i][1]);
15                i++;
16            }
17            while (!pq.isEmpty() && pq.peek() < day) {
18                pq.poll();
19            }
20            if (!pq.isEmpty()) {
21                pq.poll();
22                count++;
23            }
24            day++;
25        }
26        return count;
27    }
28}
// Last updated: 2/3/2026, 6:27:18 PM
1class Solution {
2    public List<List<Integer>> kSmallestPairs(
3        int[] nums1, int[] nums2, int k
4    ) {
5        List<List<Integer>> res = new ArrayList<>();
6        if (nums1.length == 0 || nums2.length == 0)
7            return res;
8
9        PriorityQueue<int[]> pq =
10            new PriorityQueue<>(
11                (a, b) ->
12                    (nums1[a[0]] + nums2[a[1]])
13                  - (nums1[b[0]] + nums2[b[1]])
14            );
15
16        for (int i = 0; i < Math.min(k, nums1.length); i++) {
17            pq.add(new int[]{i, 0});
18        }
19
20        while (k-- > 0 && !pq.isEmpty()) {
21            int[] cur = pq.poll();
22            int i = cur[0], j = cur[1];
23
24            res.add(
25                Arrays.asList(nums1[i], nums2[j])
26            );
27
28            if (j + 1 < nums2.length) {
29                pq.add(new int[]{i, j + 1});
30            }
31        }
32
33        return res;
34    }
35}
36
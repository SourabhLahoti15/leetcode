// Last updated: 4/16/2026, 12:08:39 AM
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int n = nums.length;
4        int[] res = new int[n-k+1];
5        Deque<Integer> dq = new ArrayDeque<>();
6        for (int i=0; i<n; i++) {
7            // remove out of window
8            if (!dq.isEmpty() && dq.peekFirst() <= i-k) {
9                dq.pollFirst();
10            }
11            // remove smaller elements
12            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
13                dq.pollLast();
14            }
15            dq.offerLast(i);
16            // store answer
17            if (i >= k-1) {
18                res[i-k+1] = nums[dq.peekFirst()];
19            }
20        }
21        return res;
22    }
23}
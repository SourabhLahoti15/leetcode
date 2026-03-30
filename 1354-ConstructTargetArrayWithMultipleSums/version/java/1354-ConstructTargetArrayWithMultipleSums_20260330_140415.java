// Last updated: 3/30/2026, 2:04:15 PM
1class Solution {
2    public boolean isPossible(int[] target) {
3        long sum = 0;
4        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
5        
6        for (int num : target) {
7            sum += num;
8            maxHeap.add(num);
9        }
10        
11        while (true) {
12            int max = maxHeap.poll();
13            long rest = sum - max;
14            
15            // base cases
16            if (max == 1 || rest == 1) return true;
17            if (rest == 0 || max <= rest) return false;
18            
19            int prev = (int)(max % rest);
20            
21            if (prev == 0) return false;
22            
23            maxHeap.add(prev);
24            sum = rest + prev;
25        }
26    }
27}
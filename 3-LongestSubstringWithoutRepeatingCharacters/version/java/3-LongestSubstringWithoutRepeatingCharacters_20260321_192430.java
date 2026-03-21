// Last updated: 3/21/2026, 7:24:30 PM
1class Solution {
2    public int[][] merge(int[][] intervals) {
3        int n = intervals.length;
4        Arrays.sort(intervals, (a, b) -> {
5            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
6            return Integer.compare(a[0], b[0]);
7        });
8        List<int[]> l = new ArrayList<>();
9        boolean[] isAdded = new boolean[n];
10        for (int i=0; i<n; i++) {
11            int[] interval = intervals[i];
12            for (int j=i+1; j<n; j++) {
13                if (!isAdded[j]) {
14                    if (interval[1] >= intervals[j][0]) {
15                        interval[1] = Math.max(interval[1], intervals[j][1]);
16                        isAdded[j] = true;
17                    }
18                }
19            }
20            if (!isAdded[i]) {
21                l.add(interval);
22                isAdded[i] = true;
23            }
24        }
25        int[][] arr = l.toArray(new int[l.size()][]);
26        return arr;
27    }
28}
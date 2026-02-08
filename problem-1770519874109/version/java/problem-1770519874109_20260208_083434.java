// Last updated: 2/8/2026, 8:34:34 AM
1class Solution {
2    public List<Long> mergeAdjacent(int[] nums) {
3        List<Long> l = new ArrayList<>();
4        for (int num : nums) {
5            l.add((long) num);
6        }
7        int n = nums.length;
8        if (n == 1) return l;
9        int i=1;
10        while (i<l.size()) {
11            if (l.get(i).equals(l.get(i-1))) {
12                long sum = l.get(i) + l.get(i-1);
13                l.set(i-1, sum);
14                l.remove(i);
15                if (i-1 != 0)
16                    i--;
17            } else {
18                i++;
19            }
20        }
21        return l;
22    }
23}
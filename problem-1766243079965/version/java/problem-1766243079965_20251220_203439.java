// Last updated: 12/20/2025, 8:34:39 PM
1class Solution {
2    public int minOperations(int[] nums) {
3        Map<Integer, Integer> m = new HashMap<>();
4        int duplicate = 0;
5        for (int x:nums) {
6            m.put(x, m.getOrDefault(x, 0)+1);
7            if (m.get(x) == 2) {
8                duplicate++;
9            }
10        }
11        if (duplicate==0) return 0;
12        int op=0;
13        int idx=0;
14        int n=nums.length;
15        while (idx<n) {
16            op++;
17            for (int i=0; i<3 && idx<n; i++, idx++) {
18                int val=nums[idx];
19                int count=m.get(val);
20                m.put(val, count-1);
21                if (count==2) {
22                    duplicate--;
23                }
24            }
25            if (duplicate==0) {
26                return op;
27            }
28        }
29        return op;
30    }
31}
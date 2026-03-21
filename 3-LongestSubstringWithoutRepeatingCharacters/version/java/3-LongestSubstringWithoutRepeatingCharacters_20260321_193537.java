// Last updated: 3/21/2026, 7:35:37 PM
1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3        int min = nums[0];
4        int max = nums[1];
5        int n = nums.length;
6        for (int i=0; i<n; i++) {
7            min = Math.min(min, nums[i]);
8            max = Math.max(max, nums[i]);
9        }
10        boolean[] a = new boolean[max - min + 1];
11        for (int i=0; i<n; i++) {
12            a[nums[i] - min] = true;
13        }
14        List<Integer> l = new ArrayList<>();
15        for (int i=0; i<a.length; i++) {
16            if (!a[i]) {
17                l.add(i+min);
18            }
19        }
20        return l;
21    }
22}
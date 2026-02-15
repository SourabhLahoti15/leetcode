// Last updated: 2/15/2026, 8:39:24 AM
1class Solution {
2    public int firstUniqueFreq(int[] nums) {
3        HashMap<Integer, Integer> hm = new HashMap<>();;
4        for (int num : nums) {
5            hm.put(num, hm.getOrDefault(num, 0) + 1);
6        }
7        HashMap<Integer, Integer> freqcount = new HashMap<>();
8        for (int freq : hm.values()) {
9            freqcount.put(freq, freqcount.getOrDefault(freq, 0) + 1);
10        }
11        for (int num : nums) {
12            int freq = hm.get(num);
13            if (freqcount.get(freq) == 1) {
14                return num;
15            }
16        }
17        return -1;
18    }
19}
// Last updated: 6/14/2026, 10:04:00 AM
class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();;
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, Integer> freqcount = new HashMap<>();
        for (int freq : hm.values()) {
            freqcount.put(freq, freqcount.getOrDefault(freq, 0) + 1);
        }
        for (int num : nums) {
            int freq = hm.get(num);
            if (freqcount.get(freq) == 1) {
                return num;
            }
        }
        return -1;
    }
}
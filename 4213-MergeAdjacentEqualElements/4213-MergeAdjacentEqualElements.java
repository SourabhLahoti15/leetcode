// Last updated: 6/14/2026, 10:04:04 AM
class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> l = new ArrayList<>();
        for (int num : nums) {
            l.add((long) num);
        }
        int n = nums.length;
        if (n == 1) return l;
        int i=1;
        while (i<l.size()) {
            if (l.get(i).equals(l.get(i-1))) {
                long sum = l.get(i) + l.get(i-1);
                l.set(i-1, sum);
                l.remove(i);
                if (i-1 != 0)
                    i--;
            } else {
                i++;
            }
        }
        return l;
    }
}
// Last updated: 6/14/2026, 10:04:13 AM
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int duplicate = 0;
        for (int x:nums) {
            m.put(x, m.getOrDefault(x, 0)+1);
            if (m.get(x) == 2) {
                duplicate++;
            }
        }
        if (duplicate==0) return 0;
        int op=0;
        int idx=0;
        int n=nums.length;
        while (idx<n) {
            op++;
            for (int i=0; i<3 && idx<n; i++, idx++) {
                int val=nums[idx];
                int count=m.get(val);
                m.put(val, count-1);
                if (count==2) {
                    duplicate--;
                }
            }
            if (duplicate==0) {
                return op;
            }
        }
        return op;
    }
}
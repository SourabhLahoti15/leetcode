// Last updated: 2/18/2026, 9:20:26 AM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        ArrayList<Integer> bits = new ArrayList<>();
4        while (n>0) {
5            int bit = n%2;
6            n = n/2;
7            bits.add(bit);
8        }
9        for (int i=1; i<bits.size(); i++) {
10            if (bits.get(i-1) == bits.get(i)) return false;
11        }
12        return true;
13    }
14}
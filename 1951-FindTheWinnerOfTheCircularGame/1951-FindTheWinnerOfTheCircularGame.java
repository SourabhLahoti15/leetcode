// Last updated: 12/17/2025, 10:51:16 AM
class Solution {
    public int recursion(List<Integer> l, int k, int start) {
        if (l.size() == 1) {
            return l.get(0);
        }
        int i = (start+k-1)%l.size();
        l.remove(i);
        return recursion(l, k, i);
    }
    public int findTheWinner(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            l.add(i);
        }
        return recursion(l, k, 0);        
    }
}
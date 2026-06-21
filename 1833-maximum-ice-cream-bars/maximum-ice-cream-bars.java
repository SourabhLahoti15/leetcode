class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        if (costs[0] > coins) return 0;
        for (int i=0; i<n; i++) {
            coins -= costs[i];
            if (coins == 0) return i+1;
            else if (coins < 0) return i;
        }
        return n;
    }
}
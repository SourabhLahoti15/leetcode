class Pair {
    int u, price, stops;
    Pair(int u, int price, int stops) {
        this.u = u;
        this.price = price;
        this.stops = stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            graph.get(u).add(new int[]{ v, price });
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0, 0));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int u = cur.u;
            int uprice = cur.price;
            int ustops = cur.stops;
            if (ustops > k) continue;
            for (int[] nei : graph.get(u)) {
                int v = nei[0];
                int vprice = nei[1];
                if (uprice + vprice < dist[v]) {
                    dist[v] = uprice + vprice;
                    q.offer(new Pair(v, dist[v], ustops+1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
// Last updated: 6/14/2026, 10:03:47 AM
class EventManager {
    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> map = new HashMap<>();
    public EventManager(int[][] events) {
        pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            }
        );
        map = new HashMap<>();
        for (int[] e : events) {
            map.put(e[0], e[1]);
            pq.offer(new int[]{ e[0], e[1] });
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new int[]{ eventId, newPriority });
    }

    public int pollHighest() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (map.containsKey(top[0]) && map.get(top[0]) == top[1]) {
                map.remove(top[0]);
                return top[0];
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */
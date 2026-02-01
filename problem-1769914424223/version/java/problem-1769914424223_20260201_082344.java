// Last updated: 2/1/2026, 8:23:44 AM
1class RideSharingSystem {
2    Queue<Integer> driver;
3    Queue<Integer> rider;
4    public RideSharingSystem() {
5        driver = new LinkedList<Integer>();
6        rider = new LinkedList<Integer>();
7    }
8    
9    public void addRider(int riderId) {
10        rider.offer(riderId);
11    }
12    
13    public void addDriver(int driverId) {
14        driver.offer(driverId);
15    }
16    
17    public int[] matchDriverWithRider() {
18        if (driver.isEmpty() || rider.isEmpty()) {
19            return new int[] {-1, -1};
20        }
21        return new int[] {driver.poll(), rider.poll()};
22    }
23    
24    public void cancelRider(int riderId) {
25        if (rider.contains(riderId)) {
26            rider.remove(riderId);
27        }
28    }
29}
30
31/**
32 * Your RideSharingSystem object will be instantiated and called as such:
33 * RideSharingSystem obj = new RideSharingSystem();
34 * obj.addRider(riderId);
35 * obj.addDriver(driverId);
36 * int[] param_3 = obj.matchDriverWithRider();
37 * obj.cancelRider(riderId);
38 */
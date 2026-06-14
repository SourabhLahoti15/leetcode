// Last updated: 6/14/2026, 10:04:20 AM
class RideSharingSystem {
    Queue<Integer> driver;
    Queue<Integer> rider;
    public RideSharingSystem() {
        driver = new LinkedList<Integer>();
        rider = new LinkedList<Integer>();
    }
    
    public void addRider(int riderId) {
        rider.offer(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if (driver.isEmpty() || rider.isEmpty()) {
            return new int[] {-1, -1};
        }
        return new int[] {driver.poll(), rider.poll()};
    }
    
    public void cancelRider(int riderId) {
        if (rider.contains(riderId)) {
            rider.remove(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
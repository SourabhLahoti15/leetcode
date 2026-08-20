class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> hmap = new HashMap<>();
        for (int[] reserved : reservedSeats) {
            int row = reserved[0];
            int seat = reserved[1];
            if (!hmap.containsKey(row)) {
                hmap.put(row, new HashSet<>());
            }
            hmap.get(row).add(seat);
        }
        int result = (n - hmap.size()) * 2;
        for (Map.Entry<Integer, HashSet<Integer>> e : hmap.entrySet()) {
            HashSet<Integer> reserved = e.getValue();
            boolean groupA = !reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5);
            boolean groupB = !reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7);
            boolean groupC = !reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8) && !reserved.contains(9);
            if (groupA && groupC) {
                result += 2;
            } else if (groupA || groupB || groupC) {
                result++;
            }
        }
        return result;
    }
}
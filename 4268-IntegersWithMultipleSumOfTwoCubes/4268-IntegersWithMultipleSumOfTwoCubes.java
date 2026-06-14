// Last updated: 6/14/2026, 10:03:46 AM
class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int a = 1; (long) a * a * a < n; a++) {
            for (int b = a; (long) a * a * a + (long) b * b * b <= n; b++) {
                int sum = (int) ((long) a * a * a + (long) b * b * b);
                countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }
        
        Collections.sort(result);
        return result;
    }
}
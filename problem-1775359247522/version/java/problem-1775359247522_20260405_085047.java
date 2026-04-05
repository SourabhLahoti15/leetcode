// Last updated: 4/5/2026, 8:50:47 AM
1class Solution {
2    public List<Integer> findGoodIntegers(int n) {
3        Map<Integer, Integer> countMap = new HashMap<>();
4        
5        for (int a = 1; (long) a * a * a < n; a++) {
6            for (int b = a; (long) a * a * a + (long) b * b * b <= n; b++) {
7                int sum = (int) ((long) a * a * a + (long) b * b * b);
8                countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
9            }
10        }
11        
12        List<Integer> result = new ArrayList<>();
13        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
14            if (entry.getValue() >= 2) {
15                result.add(entry.getKey());
16            }
17        }
18        
19        Collections.sort(result);
20        return result;
21    }
22}
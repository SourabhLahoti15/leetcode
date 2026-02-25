// Last updated: 2/25/2026, 3:13:02 PM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Integer[] temp = new Integer[arr.length];
4        
5        for (int i = 0; i < arr.length; i++) {
6            temp[i] = arr[i];
7        }
8
9        Arrays.sort(temp, (a, b) -> {
10            int countA = Integer.bitCount(a);
11            int countB = Integer.bitCount(b);
12            
13            if (countA == countB) {
14                return a - b;
15            }
16            return countA - countB;
17        });
18
19        for (int i = 0; i < arr.length; i++) {
20            arr[i] = temp[i];
21        }
22
23        return arr;
24    }
25}
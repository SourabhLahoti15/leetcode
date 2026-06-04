// Last updated: 6/4/2026, 1:43:51 PM
1class Solution {
2    public int totalWaviness(int num1, int num2) {
3        if (num1 / 100 == 0 && num2 / 100 == 0) {
4            return 0;            
5        }
6        int count = 0;
7        for (int i = num1; i <= num2; i++) {
8            if (i/100 == 0)
9                continue;
10            int num = i;
11            int right = num % 10;
12            num = num / 10;
13            int middle = num % 10;
14            num = num / 10;
15            while (num > 0) {
16                int left = num % 10;
17                num = num / 10;
18                if ((middle > left && middle > right) || (middle < left && middle < right)) {
19                    count++;
20                }
21                right = middle;
22                middle = left;                
23            }
24        }
25        return count;
26    }
27}
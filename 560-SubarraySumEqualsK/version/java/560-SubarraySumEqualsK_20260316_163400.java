// Last updated: 3/16/2026, 4:34:00 PM
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int product = 1;
5        int zproduct = 1;
6        int numZeroes = n;
7        for (int num : nums) {
8            if (num != 0) {
9                zproduct *= num;
10                numZeroes--;
11            }
12            product *= num;
13        }
14        int[] answer = new int[n];
15        if (numZeroes == n) {
16            return answer;
17        }
18        for (int i=0; i<n; i++) {
19            if (nums[i] == 0) {
20                if (numZeroes > 1)
21                    answer[i] = 0;
22                else 
23                    answer[i] = zproduct;
24            } else {
25                answer[i] = product/nums[i];
26            }
27        }
28        return answer;
29    }
30}
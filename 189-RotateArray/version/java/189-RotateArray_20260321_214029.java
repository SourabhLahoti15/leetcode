// Last updated: 3/21/2026, 9:40:29 PM
1class Solution {
2    public void rotate(int[] nums, int k) {
3        int n = nums.length;
4        k = k%n;
5        int i = 0;
6        int j = n-1;
7        while (i <= j) {
8            int temp = nums[i];
9            nums[i] = nums[j];
10            nums[j] = temp;
11            i++;
12            j--;
13        }
14        i = 0;
15        j = k-1;
16        while (i <= j) {
17            int temp = nums[i];
18            nums[i] = nums[j];
19            nums[j] = temp;
20            i++;
21            j--;
22        }
23        i = k;
24        j = n-1;
25        while (i <= j) {
26            int temp = nums[i];
27            nums[i] = nums[j];
28            nums[j] = temp;
29            i++;
30            j--;
31        }
32    }
33}
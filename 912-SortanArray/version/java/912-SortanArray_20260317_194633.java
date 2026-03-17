// Last updated: 3/17/2026, 7:46:33 PM
1class Solution {
2    // public void insert(ArrayList<Integer> nums, int num1) {
3    //     if (nums.size() == 0 || nums.get(nums.size()-1) <= num1) {
4    //         nums.add(num1);
5    //     }
6    //     int num2 = nums.remove(nums.size()-1);
7    //     insert(nums, num1);
8    //     nums.add(num2);
9    // }
10    // public void sort(int[] nums) {
11    //     if (nums.length == 1) {
12    //         return;
13    //     }
14    //     int num1 = nums.pop();
15    //     sort(nums);
16    //     insert(nums, num1);
17    // }
18    public int[] sortArray(int[] nums) {
19        Arrays.sort(nums);
20        return nums;
21    }
22}
// Last updated: 3/18/2026, 2:44:46 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode sortedArrayToBST(int[] nums) {
18        int n = nums.length;
19        if (n == 0) return null;
20        int mid = n/2;
21        TreeNode root = new TreeNode(nums[mid]);
22        int[] leftnums = Arrays.copyOfRange(nums, 0, mid);
23        TreeNode left = sortedArrayToBST(leftnums);
24        int[] rightnums = Arrays.copyOfRange(nums, mid+1, n);
25        TreeNode right = sortedArrayToBST(rightnums);
26        root.left = left;
27        root.right = right;
28        return root;
29    }
30}
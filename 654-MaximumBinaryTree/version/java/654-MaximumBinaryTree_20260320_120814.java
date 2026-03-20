// Last updated: 3/20/2026, 12:08:14 PM
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
17    public TreeNode constructMaximumBinaryTree(int[] nums) {
18        int n = nums.length;
19        if (n == 0) return null;
20        int max = nums[0];
21        int maxidx = 0;
22        for (int i=0; i<n; i++) {
23            if (nums[i] > max) {
24                max = nums[i];
25                maxidx = i;
26            }
27        }
28        TreeNode root = new TreeNode(max);
29        TreeNode left = null;
30        if (maxidx != 0) {
31            left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxidx));
32        }
33        TreeNode right = null;
34        if (maxidx != n-1) {
35            right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxidx+1, n));
36        } 
37        root.left = left;
38        root.right = right;
39        return root;
40    }
41}
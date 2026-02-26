// Last updated: 2/26/2026, 11:54:23 AM
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
17    public TreeNode invertTree(TreeNode root) {
18        if (root == null) return null;
19        TreeNode temp = root.left;
20        root.left = root.right;
21        root.right = temp;
22        invertTree(root.left);
23        invertTree(root.right);
24        return root;
25    }
26}
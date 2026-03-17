// Last updated: 3/17/2026, 11:33:04 AM
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
17    int diameter = 0;
18    public int maxHeight(TreeNode root) {
19        if (root == null) {
20            return 0;
21        }
22        int left = maxHeight(root.left);
23        int right = maxHeight(root.right);
24        diameter = Math.max(diameter, left + right);
25        return 1 + Math.max(left, right);
26    }
27    public int diameterOfBinaryTree(TreeNode root) {
28        maxHeight(root);
29        return diameter;
30    }
31}
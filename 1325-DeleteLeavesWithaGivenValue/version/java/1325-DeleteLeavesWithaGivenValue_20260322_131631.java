// Last updated: 3/22/2026, 1:16:31 PM
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
17    public boolean isLeaf(TreeNode root) {
18        return root.left == null && root.right == null;
19    }
20    public TreeNode removeLeafNodes(TreeNode root, int target) {
21        if (root == null) return null;
22        root.left = removeLeafNodes(root.left, target);
23        root.right = removeLeafNodes(root.right, target);
24        if (isLeaf(root) && root.val == target) {
25            root = null;
26        }
27        return root;
28    }
29}
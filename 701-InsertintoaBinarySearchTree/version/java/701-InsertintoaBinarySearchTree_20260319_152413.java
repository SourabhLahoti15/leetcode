// Last updated: 3/19/2026, 3:24:13 PM
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
17    public TreeNode insertIntoBST(TreeNode root, int val) {
18        if (root == null) return new TreeNode(val);
19
20        if (val < root.val) {
21            root.left = insertIntoBST(root.left, val);
22        } else {
23            root.right = insertIntoBST(root.right, val);
24        }
25
26        return root;
27    }
28}
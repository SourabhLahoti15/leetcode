// Last updated: 3/19/2026, 2:42:58 PM
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
17    public TreeNode addOneRow(TreeNode root, int val, int depth) {
18        if (root == null)
19            return null;
20        if (depth == 1) {
21            TreeNode node = new TreeNode(val);
22            node.left = root;
23            return node;
24        }
25        if (depth == 2) {
26            TreeNode left = root.left;
27            TreeNode right = root.right;
28            root.left = new TreeNode(val);
29            root.right = new TreeNode(val);
30            root.left.left = left;
31            root.right.right = right;
32        } else {
33            addOneRow(root.left, val, depth - 1);
34            addOneRow(root.right, val, depth - 1);
35        }
36        return root;
37    }
38}
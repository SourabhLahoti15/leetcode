// Last updated: 3/19/2026, 2:21:43 PM
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
17    public String tree2str(TreeNode root) {
18        String s = "";
19        if (root == null)
20            return "";
21        s += root.val;
22        String left = tree2str(root.left);
23        String right = tree2str(root.right);
24        if (left == "" && right == "") {
25            return s;
26        }
27        s += "(" + left + ")";
28        if (right == "") {
29            return s;
30        }
31        s += "(" + right + ")";
32        return s;
33    }
34}
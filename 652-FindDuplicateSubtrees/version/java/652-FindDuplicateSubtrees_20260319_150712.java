// Last updated: 3/19/2026, 3:07:12 PM
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
17    Map<String, Integer> map = new HashMap<>();
18    List<TreeNode> res = new ArrayList<>();
19
20    // public boolean isDuplicate(TreeNode root1, TreeNode root2) {
21    //     if (root1 == null && root2 == null) return true;
22    //     if (root1 == null || root2 == null) return false;
23    //     if (root1.val != root2.val) return false;
24    //     return isDuplicate(root1.left, root2.left) && isDuplicate(root1.right, root2.right);
25    // }
26    private String serialize(TreeNode node) {
27        if (node == null) return "null";
28        String s = node.val + "," +
29                   serialize(node.left) + "," +
30                   serialize(node.right);
31        int count = map.getOrDefault(s, 0);
32        if (count == 1) {
33            res.add(node);
34        }
35        map.put(s, count + 1);
36        return s;
37    }
38    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
39        serialize(root);
40        return res;
41    }
42}
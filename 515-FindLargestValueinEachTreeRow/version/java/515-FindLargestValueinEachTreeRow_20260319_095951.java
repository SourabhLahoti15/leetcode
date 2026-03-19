// Last updated: 3/19/2026, 9:59:51 AM
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
17    public List<Integer> largestValues(TreeNode root) {
18        List<Integer> res = new ArrayList<>();
19        Queue<TreeNode> q = new LinkedList<>();
20        if (root == null) return res;
21        q.offer(root);
22        while (!q.isEmpty()) {
23            int size = q.size();
24            int max = Integer.MIN_VALUE;
25            for (int i=0; i<size; i++) {
26                TreeNode node = q.poll();
27                int val = node.val;
28                max = Math.max(max, val);
29                if (node.left != null) q.offer(node.left);
30                if (node.right != null) q.offer(node.right);
31            }
32            res.add(max);
33        }
34        return res;
35    }
36}
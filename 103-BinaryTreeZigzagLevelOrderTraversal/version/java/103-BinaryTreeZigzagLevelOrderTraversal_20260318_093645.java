// Last updated: 3/18/2026, 9:36:45 AM
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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18        List<List<Integer>> lot = new ArrayList<>();
19        if (root == null) return lot;
20        Queue<TreeNode> q = new LinkedList<>();
21        q.offer(root);
22        while (!q.isEmpty()) {
23            int size = q.size();
24            List<Integer> lev = new ArrayList<>();
25            for (int i=0; i<size; i++) {
26                TreeNode node = q.poll();
27                int val = node.val;
28                lev.add(val);
29                if (node.left != null) q.offer(node.left);
30                if (node.right != null) q.offer(node.right);
31            }
32            if (lot.size() % 2 != 0) {
33                Collections.reverse(lev);
34                lot.add(lev);
35            } else {
36                lot.add(lev);
37            }
38        }
39        return lot;
40    }
41}
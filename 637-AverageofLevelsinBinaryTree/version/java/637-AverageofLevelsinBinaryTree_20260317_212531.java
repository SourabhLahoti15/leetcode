// Last updated: 3/17/2026, 9:25:31 PM
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
17    public List<Double> averageOfLevels(TreeNode root) {
18        List<Double> res = new ArrayList<>();
19        Queue<TreeNode> q = new LinkedList<>();
20        q.offer(root);
21        while (!q.isEmpty()) {
22            int size = q.size();
23            long sum = 0;
24            for (int i=0; i<size; i++) {
25                TreeNode node = q.poll();
26                int val = node.val;
27                sum += val;
28                if (node.left != null) {
29                    q.offer(node.left);
30                }
31                if (node.right != null) {
32                    q.offer(node.right);
33                }
34            }
35            res.add((double)sum/size);
36        }
37        return res;
38    }
39}
// Last updated: 3/20/2026, 11:29:34 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    static HashMap<TreeNode, TreeNode> parent = new HashMap<>();
12    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
13        buildParent(root, null);
14        Queue<TreeNode> q = new LinkedList<>();
15        Set<TreeNode> visited = new HashSet<>();
16        q.offer(target);
17        visited.add(target);
18        int dist = 0;
19        while (!q.isEmpty()) {
20            if (dist == k) break;
21            int size = q.size();
22            for (int i = 0; i < size; i++) {
23                TreeNode node = q.poll();
24                if (node.left != null && visited.add(node.left)) {
25                    q.offer(node.left);
26                }
27                if (node.right != null && visited.add(node.right)) {
28                    q.offer(node.right);
29                }
30                if (parent.get(node) != null && visited.add(parent.get(node))) {
31                    q.offer(parent.get(node));
32                }
33            }
34            dist++;
35        }
36        List<Integer> res = new ArrayList<>();
37        while (!q.isEmpty()) {
38            res.add(q.poll().val);
39        }
40        return res;
41    }
42    public void buildParent(TreeNode node, TreeNode par) {
43        if (node == null) return;
44        parent.put(node, par);
45        buildParent(node.left, node);
46        buildParent(node.right, node);
47    }
48}
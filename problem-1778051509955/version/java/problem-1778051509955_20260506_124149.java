// Last updated: 5/6/2026, 12:41:49 PM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node left;
6    public Node right;
7    public Node next;
8
9    public Node() {}
10    
11    public Node(int _val) {
12        val = _val;
13    }
14
15    public Node(int _val, Node _left, Node _right, Node _next) {
16        val = _val;
17        left = _left;
18        right = _right;
19        next = _next;
20    }
21};
22*/
23
24class Solution {
25    public Node connect(Node root) {
26        Queue<Node> q = new LinkedList<>();
27        if (root != null) {
28            q.offer(root);
29            root.next = null;
30        } 
31        while (!q.isEmpty()) {
32            int size = q.size();
33            List<Node> l = new ArrayList<>();
34            while (size-- > 0) {
35                Node cur = q.poll();
36                l.add(cur);
37                if (cur.left != null) q.offer(cur.left);
38                if (cur.right != null) q.offer(cur.right);
39            }
40            for (int i=1; i<l.size(); i++) {
41                l.get(i-1).next = l.get(i);
42            }
43            l.get(l.size()-1).next = null;
44            l.clear();
45        }
46        return root;
47    }
48}
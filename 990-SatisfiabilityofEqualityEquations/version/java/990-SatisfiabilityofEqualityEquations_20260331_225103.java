// Last updated: 3/31/2026, 10:51:03 PM
1class Solution {
2    int[] parent;
3    public int find(int x) {
4        if (parent[x] == x) {
5            return x;
6        }
7        return parent[x] = find(parent[x]);
8    }
9    public void union(int a, int b) {
10        int pa = find(a);
11        int pb = find(b);
12        if (pa != pb) {
13            parent[pa] = pb;
14        }
15    }
16    public boolean equationsPossible(String[] equations) {
17        parent = new int[26];
18        for (int i=0; i<26; i++) {
19            parent[i] = i;
20        }
21        for (String eq : equations) {
22            if (eq.charAt(1) == '=') {
23                union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
24            }
25        }
26        for (String eq : equations) {
27            if (eq.charAt(1) == '!') {
28                if (find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) {
29                    return false;
30                }
31            }
32        }
33        return true;
34    }
35}
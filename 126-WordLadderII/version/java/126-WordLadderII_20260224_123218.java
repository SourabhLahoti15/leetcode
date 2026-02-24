// Last updated: 2/24/2026, 12:32:18 PM
1class Solution {
2    static int[] parent;
3    static int[] size;
4    public int find(int x) {
5        if (parent[x] == x) return x;
6        return parent[x] = find(parent[x]);
7    }
8    public void dsu(int u, int v) {
9        int uparent = find(u);
10        int vparent = find(v);
11        if (uparent == vparent) {
12            return;
13        }
14        if (size[uparent] > size[vparent]) {
15            parent[vparent] = uparent;
16            size[uparent] += size[vparent];
17        } else {
18            parent[uparent] = vparent;
19            size[vparent] += size[uparent];
20        }
21    }
22    public List<List<String>> accountsMerge(List<List<String>> accounts) {
23        int n = accounts.size();
24        parent = new int[n];
25        size = new int[n];
26        for (int i = 0; i < n; i++) {
27            parent[i] = i;
28            size[i] = 1;
29        }
30        HashMap<String, Integer> hm = new HashMap<>();
31        for (int i=0; i<n; i++) {
32            List<String> account = accounts.get(i);
33            for (int j=1; j<account.size(); j++) {
34                String mail = account.get(j);
35                if (hm.containsKey(mail)) {
36                    dsu(hm.get(mail), i);
37                } else {
38                    hm.put(mail, i);
39                }
40            }
41        }
42        HashMap<Integer, TreeSet<String>> groups = new HashMap<>();
43        for (String mail : hm.keySet()) {
44            int acc_idx = hm.get(mail);
45            int par_acc_idx = find(acc_idx);
46            if (!groups.containsKey(par_acc_idx)) {
47                groups.put(par_acc_idx, new TreeSet<>());
48            }
49            groups.get(par_acc_idx).add(mail);
50        }
51        List<List<String>> result = new ArrayList<>();
52        for (int par_acc_idx : groups.keySet()) {
53            List<String> par_acc = new ArrayList<>();
54            par_acc.add(accounts.get(par_acc_idx).get(0));
55            par_acc.addAll(groups.get(par_acc_idx));
56            result.add(par_acc);
57        }
58        return result;
59    }
60}
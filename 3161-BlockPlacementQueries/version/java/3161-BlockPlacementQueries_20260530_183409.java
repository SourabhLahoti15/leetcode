// Last updated: 5/30/2026, 6:34:09 PM
1class Solution {
2    public List<Boolean> getResults(int[][] queries) {
3        int rmax = 500001;
4        
5        SegmentTree st = new SegmentTree(rmax); // 4*rmax
6        TreeSet<Integer> tset = new TreeSet<>();
7        List<Boolean> ans = new ArrayList<>();
8
9        tset.add(0);
10        tset.add(rmax);
11        // 0________rmax
12
13        st.insert(rmax, rmax);
14
15        for(int q[] :queries) {
16            // Q.logn (n=50000)
17
18            // 4*n, Q
19            if(q[0]==1) {
20                // insert
21                int x = q[1];
22                int left = tset.floor(x-1);
23                int right = tset.ceiling(x+1);
24                tset.add(x);
25                // 0____x__rmax
26                st.insert(x, x-left);
27                st.insert(right, right-x);
28            }
29            else {
30                // query
31                //  0___prev__x___rmax
32                int x = q[1];
33                int size = q[2];
34                int prev = tset.floor(x);
35                int maxGap = st.query(0, prev);
36
37                int max = Math.max(maxGap, x-prev);
38
39                ans.add(size<=max);
40            }
41        }
42
43        return ans;
44    }
45}
46
47class SegmentTree {
48    int seg[];
49    int size;
50
51    SegmentTree(int size) {
52        this.size = size;
53        this.seg = new int[size*4];
54    }
55
56    void insert(int idx, int val, int curr, int l, int r) {
57        if(l==r) {
58            seg[curr] = val;
59            return;
60        }
61        int mid = (l+r)/2;
62
63        if(idx<=mid) {
64            insert(idx, val, curr*2, l, mid);
65        } else {
66            insert(idx, val, curr*2+1, mid+1, r);
67        }
68        seg[curr] = Math.max(seg[curr*2], seg[curr*2+1]);
69    }
70
71    int query(int qleft, int qright, int curr, int l, int r) {
72        // qleft__l__r__qright
73        if(qleft<=l && qright>=r)
74            return seg[curr];
75        int mid = (l+r)/2;
76        int maxGap = 0;
77        // left
78        if(qleft<=mid) {
79            maxGap = Math.max(maxGap, query(qleft, qright, curr*2, l, mid));
80        }
81        // right
82        if(qright > mid) {
83            maxGap = Math.max(maxGap, query(qleft, qright, curr*2+1, mid+1, r));
84        }
85
86        return maxGap;
87    }
88
89    void insert(int idx, int val) {
90        // curr = root = 1, left = 0, right = max = 500001
91        insert(idx, val, 1, 0, size);
92    }
93
94    int query(int left, int right) {
95        return query(left, right, 1, 0, size);
96    }
97}
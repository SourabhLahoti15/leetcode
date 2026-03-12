// Last updated: 3/12/2026, 2:08:42 PM
1class NumArray {
2    int[] nums;
3    int[] st;
4    public NumArray(int[] nums) {
5        this.nums = nums;
6        st = new int[4*nums.length];
7        build(0, 0, nums.length-1);
8    }
9
10    public void build(int i, int l, int r) {
11        if (l == r) {
12            st[i] = nums[l];
13            return;
14        }
15        int mid = l + (r-l)/2;
16        build(2*i+1, l, mid);
17        build(2*i+2, mid+1, r);
18        st[i] = st[2*i+1] + st[2*i+2];
19    }
20
21    public void updatetree(int i, int index, int l, int r, int val) {
22        if (l == r) {
23            st[i] = val;
24            return;
25        }
26        int mid = l + (r-l)/2;
27        if (index <= mid) {
28            updatetree(2*i+1, index, l, mid, val);
29        } else {
30            updatetree(2*i+2, index, mid+1, r, val);
31        }
32        st[i] = st[2*i+1] + st[2*i+2];
33    }
34
35    public void update(int index, int val) {
36        updatetree(0, index, 0, nums.length-1, val);
37    }
38
39    public int query(int i, int left, int right, int l, int r) {
40        if (r < left || right < l) {
41            return 0;
42        }
43        if (left <= l && r <= right) {
44            return st[i];
45        }
46        int mid = l + (r-l)/2;
47        int leftchild = query(2*i+1, left, right, l, mid);
48        int rightchild = query(2*i+2, left, right, mid+1, r);
49        return leftchild + rightchild;
50    }
51    
52    public int sumRange(int left, int right) {
53        return query(0, left, right, 0, nums.length-1);
54    }
55}
56
57/**
58 * Your NumArray object will be instantiated and called as such:
59 * NumArray obj = new NumArray(nums);
60 * obj.update(index,val);
61 * int param_2 = obj.sumRange(left,right);
62 */
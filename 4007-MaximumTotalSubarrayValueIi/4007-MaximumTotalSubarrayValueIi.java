// Last updated: 6/14/2026, 10:04:31 AM
class SegmentTree {
    int n; 
    int[] maxValues;
    int[] minValues;
    SegmentTree(int n) {
        this.n = n;
        maxValues = new int[4*n];
        minValues = new int[4*n];
    }
    void insert(int node, int l, int r, int idx, int val) {
        if (l == r) {
            maxValues[node] = val;
            minValues[node] = val;
            return;
        }
        int mid = l + (r-l)/2;
        if (idx <= mid) {
            insert(2*node+1, l, mid, idx, val);
        } else {
            insert(2*node+2, mid+1, r, idx, val);
        }
        maxValues[node] = Math.max(maxValues[2*node+1], maxValues[2*node+2]);
        minValues[node] = Math.min(minValues[2*node+1], minValues[2*node+2]);
    }
    int[] query(int node, int l, int r, int ql, int qr) {
        // outside
        if (qr < l || r < ql) {
            return new int[]{ Integer.MAX_VALUE, Integer.MIN_VALUE };
        }
        // inside
        if (ql <= l && r <= qr) {
            return new int[]{ minValues[node], maxValues[node] };
        }
        // overlap
        int mid = l + (r-l)/2;
        int[] left = query(2*node+1, l, mid, ql, qr);
        int[] right = query(2*node+2, mid+1, r, ql, qr);
        return new int[]{
            Math.min(left[0], right[0]),
            Math.max(left[1], right[1])
        };
    }
}
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        for (int i=0; i<n; i++) {
            st.insert(0, 0, n-1, i, nums[i]);
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        int[] arrVal = st.query(0, 0, n-1, 0, n-1);
        pq.offer(new long[]{ arrVal[1]-arrVal[0], 0, n-1 });
        Set<String> visited = new HashSet<>();
        visited.add(0 + "-" + (n-1));
        long ans = 0;
        while (!pq.isEmpty() && k>0) {
            long[] cur = pq.poll();
            ans += cur[0];
            k--;
            // [l, r] -> [l, r-1] and [l+1, r]
            int l = (int)cur[1];
            int r = (int)cur[2];
            // [l, r-1]
            if (l <= r-1 && !visited.contains(l+"-"+(r-1))) {
                int[] val = st.query(0, 0, n-1, l, r-1);
                visited.add(l+"-"+(r-1));
                pq.offer(new long[]{ val[1]-val[0], l, r-1 });
            }
            // [l+1, r]
            if (l+1 <= r && !visited.contains((l+1)+"-"+r)) {
                int[] val = st.query(0, 0, n-1, l+1, r);
                visited.add((l+1)+"-"+r);
                pq.offer(new long[]{ val[1]-val[0], l+1, r });
            }
        }
        return ans;
    }
}
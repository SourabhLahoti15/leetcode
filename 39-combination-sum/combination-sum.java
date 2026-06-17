class Solution {
    List<List<Integer>> l;
    int[] candidates;
    int target;
    public void func(int i, List<Integer> cur, int sum) {
        if (sum == target) {
            l.add(new ArrayList<>(cur));
            return;
        }
        if (i == candidates.length || sum > target) return;
        // take
        cur.add(candidates[i]);
        func(i, cur, sum+candidates[i]);
        cur.remove(cur.size()-1);
        // skip
        func(i+1, cur, sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        l = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        func(0, new ArrayList<>(), 0);
        return l;
    }
}
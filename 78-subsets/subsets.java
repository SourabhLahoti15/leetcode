class Solution {
    List<List<Integer>> ans;
    int[] nums;
    public void func(int i, List<Integer> cur) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        // take
        cur.add(nums[i]);
        func(i+1, cur);
        cur.remove(cur.size()-1);
        // not take
        func(i+1, cur);
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        func(0, new ArrayList<>());
        return ans;
    }
}
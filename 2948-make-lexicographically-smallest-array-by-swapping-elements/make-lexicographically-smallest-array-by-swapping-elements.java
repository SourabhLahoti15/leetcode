class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int groupnum = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        numToGroup.put(arr[0], groupnum);
        groupToList.putIfAbsent(groupnum, new LinkedList<>());
        groupToList.get(groupnum).add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > limit) {
                groupnum++;
            }
            numToGroup.put(arr[i], groupnum);
            groupToList.putIfAbsent(groupnum, new LinkedList<>());
            groupToList.get(groupnum).add(arr[i]);
        }
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            result[i] = groupToList.get(group).pollFirst();
        }
        return result;
    }
}
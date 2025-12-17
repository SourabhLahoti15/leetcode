// Last updated: 12/17/2025, 10:52:46 AM
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> l = new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num) && map.get(num)>0){
                l.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int[] arr = new int[l.size()];
        int i=0;
        for(int num:l){
            arr[i] = num;
            i++;
        }
        return arr;
    }
}
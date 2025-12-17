// Last updated: 12/17/2025, 10:52:48 AM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            boolean found=false;
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    found = true;
                    break;
                }
            }
            if(found == true && !arrlist.contains(nums1[i])){
                arrlist.add(nums1[i]);
            }
        }
        int[] arr = new int[arrlist.size()];
        for(int i=0; i<arrlist.size(); i++){
            arr[i] = arrlist.get(i);
        }
        return arr;
    }
}
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        int minlen = String.valueOf(low).length();
        int maxlen = String.valueOf(high).length();
        List<Integer> ans = new ArrayList<>();
        for (int l=minlen; l<=maxlen; l++) {
            for (int start=0; start+l<=9; start++) {
                String substring = s.substring(start, start + l);
                int num = Integer.parseInt(substring);
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}
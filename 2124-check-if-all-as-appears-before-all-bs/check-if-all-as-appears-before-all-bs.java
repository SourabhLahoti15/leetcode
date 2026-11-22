class Solution {
    public boolean checkString(String s) {
        int aidx=-1;
        int n = s.length();
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == 'a') {
                aidx = i;
                break;
            }
        }
        for (int i=0; i<aidx; i++) {
            if (s.charAt(i) == 'b') {
                return false;
            }
        }
        return true;
    }
}
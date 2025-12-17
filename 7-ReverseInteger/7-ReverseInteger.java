// Last updated: 12/17/2025, 10:54:42 AM
class Solution {
    public int reverse(int x) {
        int revx=0;
        boolean flag = false;
        if (x<0) {
            x = -1 * x;
            flag = true;
        }
        while(x>0){
            int ld = x % 10;
            if(revx>Integer.MAX_VALUE/10 || (revx==Integer.MAX_VALUE && ld>7)){
                return 0;
            }
            revx = revx*10 + ld;
            x = x / 10;
        }
        if (flag == true) {
            revx = revx * -1;
        }
        return revx;
    }
}
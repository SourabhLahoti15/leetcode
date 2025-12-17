// Last updated: 12/17/2025, 10:51:47 AM
class Solution {
public:
    int bitwiseComplement(int n) {
        int m = n;
        int mask=0,ans;
        if (n==0){
            return 1;
        }
        while (m!=0){
            mask = ( mask << 1 ) | 1;
            m = m >> 1;
        }
        ans = (~n) & mask;
        return ans;
    }
};
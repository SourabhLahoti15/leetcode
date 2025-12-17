// Last updated: 12/17/2025, 10:53:14 AM
class Solution {
public:
    bool isPowerOfTwo(int n) {
        for (int i = 0 ; i<=30;i++){
            int ans = pow(2,i);
            if (ans == n){
                return true;
            }
        }return false;
    }
};
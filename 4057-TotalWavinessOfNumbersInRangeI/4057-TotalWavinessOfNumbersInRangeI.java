// Last updated: 12/17/2025, 10:50:50 AM
class Solution {
    public int totalWaviness(int num1, int num2) {
        if (num1 / 100 == 0 && num2 / 100 ==0) {
            return 0;            
        }
        int count = 0;
        for (int i = num1; i <= num2; i++) {
            if (i/100 == 0)
                continue;
            int num = i;
            int right = num % 10;
            num = num / 10;
            int middle = num % 10;
            num = num / 10;
            while (num > 0) {
                int left = num % 10;
                num = num / 10;
                if ((middle > left && middle > right) || (middle < left && middle < right)) {
                    count++;
                }
                right = middle;
                middle = left;                
            }
        }
        return count;
    }
}
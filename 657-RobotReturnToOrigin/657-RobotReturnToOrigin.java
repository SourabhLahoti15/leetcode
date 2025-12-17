// Last updated: 12/17/2025, 10:52:10 AM
class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;
        for (int i=0; i<moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                vertical++;
                break;
                case 'D':
                vertical--;
                break;
                case 'L':
                horizontal--;
                break;
                case 'R':
                horizontal++;
                break;
            }
        }
        return vertical==0 && horizontal==0;
    }
}
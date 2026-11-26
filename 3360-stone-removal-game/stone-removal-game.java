class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        int chance = 0;
        while (n >= remove) {
            n -= remove;
            remove--;
            chance = 1 - chance;
        }
        return chance == 1;
    }
}
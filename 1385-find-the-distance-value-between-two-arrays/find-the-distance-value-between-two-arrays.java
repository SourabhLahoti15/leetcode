class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int dval = 0;
        for (int num1 : arr1) {
            boolean ok = true;
            for (int num2 : arr2) {
                int distance = Math.abs(num1 - num2);
                if (distance <= d) ok = false;
            }
            if (ok) dval++;
        }
        return dval;
    }
}
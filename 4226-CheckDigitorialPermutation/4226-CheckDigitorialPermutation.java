// Last updated: 6/14/2026, 10:03:58 AM
class Solution {
    static int[] dp;
    public int factorial(int n) {
        if (n <= 1) return 1;
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = n*factorial(n-1);
    }
    private void permute(char[] arr, int index) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (set.contains(arr[i])) continue;
            set.add(arr[i]);
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i); 
        }
    }
    ArrayList<String> result;
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public boolean isDigitorialPermutation(int n) {
        dp = new int[10];
        result = new ArrayList<>();
        char[] arr = String.valueOf(n).toCharArray();
        permute(arr, 0);
        for (String r : result) {
            if (r.charAt(0) == '0') continue;
            if (isDigitorial(Integer.parseInt(r))) {
                return true;
            }
        }
        return false;
    }
    public boolean isDigitorial(int n) {
        int sum = 0;
        int org_n = n;
        while (n>0) {
            int ld = n%10;
            sum += factorial(ld);
            n = n/10;
        }
        return org_n == sum;
    }
}
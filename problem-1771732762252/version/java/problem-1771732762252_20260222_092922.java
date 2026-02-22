// Last updated: 2/22/2026, 9:29:22 AM
1class Solution {
2    static int[] dp;
3    public int factorial(int n) {
4        if (n <= 1) return 1;
5        if (dp[n] != 0) {
6            return dp[n];
7        }
8        return dp[n] = n*factorial(n-1);
9    }
10    private void permute(char[] arr, int index) {
11        if (index == arr.length) {
12            result.add(new String(arr));
13            return;
14        }
15        HashSet<Character> set = new HashSet<>();
16        for (int i = index; i < arr.length; i++) {
17            if (set.contains(arr[i])) continue;
18            set.add(arr[i]);
19            swap(arr, index, i);
20            permute(arr, index + 1);
21            swap(arr, index, i); 
22        }
23    }
24    ArrayList<String> result;
25    private void swap(char[] arr, int i, int j) {
26        char temp = arr[i];
27        arr[i] = arr[j];
28        arr[j] = temp;
29    }
30    public boolean isDigitorialPermutation(int n) {
31        dp = new int[10];
32        result = new ArrayList<>();
33        char[] arr = String.valueOf(n).toCharArray();
34        permute(arr, 0);
35        for (String r : result) {
36            if (r.charAt(0) == '0') continue;
37            if (isDigitorial(Integer.parseInt(r))) {
38                return true;
39            }
40        }
41        return false;
42    }
43    public boolean isDigitorial(int n) {
44        int sum = 0;
45        int org_n = n;
46        while (n>0) {
47            int ld = n%10;
48            sum += factorial(ld);
49            n = n/10;
50        }
51        return org_n == sum;
52    }
53}
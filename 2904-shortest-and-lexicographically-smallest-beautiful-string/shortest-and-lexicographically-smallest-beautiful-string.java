class Solution {
    public int count1s(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') count++;
        }
        return count;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        for (int len=k; len<=n; len++) {
            String result = "";
            for (int st=0; st<=n-len; st++) {
                String temp = s.substring(st, st+len);
                int ones = count1s(temp);
                if (ones == k) {
                    if (result.isEmpty() || temp.compareTo(result) == -1) {
                        result = temp;
                    }
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
        }
        return "";
    }
}
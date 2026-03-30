// Last updated: 3/30/2026, 2:46:15 PM
1class Solution {
2    public String licenseKeyFormatting(String s, int k) {
3        String[] arr = s.split("-");
4        s = String.join("", arr);
5        int count = 0;
6        StringBuilder sb = new StringBuilder();
7        for (int i=s.length()-1; i>=0; i--) {
8            char ch = Character.toUpperCase(s.charAt(i));
9            if (count == k) {
10                sb.append("-");
11                count = 0;
12            }
13            sb.append(ch);
14            count++;
15        }
16        return sb.reverse().toString();
17    }
18}
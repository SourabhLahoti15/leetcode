// Last updated: 3/31/2026, 7:17:02 PM
1class Solution {
2    public String maskPhone(String s) {
3        // 10 digit phone number
4        StringBuilder sb = new StringBuilder();
5        for (int i=0; i<6; i++) {
6            sb.append("*");
7            if (i == 2) sb.append("-");
8        }
9        sb.append("-");
10        sb.append(s.substring(6, 10));
11        return sb.toString();
12    }
13    public String maskPII(String s) {
14        if (s.contains("@")) {
15            // email
16            String[] arr = s.split("@");
17            String name = arr[0];
18            int nameLen = name.length();
19            String domain = arr[1];
20            int domainLen = domain.length();
21            StringBuilder sb = new StringBuilder();
22            sb.append(Character.toLowerCase(name.charAt(0)));
23            for (int i=1; i<6; i++) {
24                sb.append("*");
25            }
26            sb.append(Character.toLowerCase(name.charAt(nameLen-1)));
27            sb.append("@");
28            for (int i=0; i<domainLen; i++) {
29                sb.append(Character.toLowerCase(domain.charAt(i)));
30            }
31            return sb.toString();
32        } else {
33            // phone
34            StringBuilder sb = new StringBuilder();
35            for (char ch : s.toCharArray()) {
36                if (Character.isDigit(ch)) {
37                    sb.append(ch);
38                }
39            }   
40            if (sb.length() == 10) {
41                String phone = maskPhone(sb.toString());
42                return phone;
43            } else if (sb.length() == 11) {
44                StringBuilder res = new StringBuilder();
45                res.append("+*-");
46                String phone = maskPhone(sb.substring(1));
47                res.append(phone);
48                return res.toString();
49            } else if (sb.length() == 12) {
50                StringBuilder res = new StringBuilder();
51                res.append("+**-");
52                String phone = maskPhone(sb.substring(2));
53                res.append(phone);
54                return res.toString();
55            } else {
56                StringBuilder res = new StringBuilder();
57                res.append("+***-");
58                String phone = maskPhone(sb.substring(3));
59                res.append(phone);
60                return res.toString();
61            }
62        }
63    }
64}
// Last updated: 12/17/2025, 10:51:35 AM
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j || words[i].length() >= words[j].length()) {
                    continue;
                }
                String txt = words[j];
                int n = txt.length();
                String pat = words[i];
                int m = pat.length();
                for (int a=0; a<=n-m; a++) {
                    int txtidx = a;
                    int b;
                    for (b=0; b<m; b++) {
                        if (txt.charAt(txtidx) != pat.charAt(b)) {
                            break;
                        }
                        txtidx++;
                    }
                    if (b == m) {
                        if(!answer.contains(pat))
                            answer.add(words[i]);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
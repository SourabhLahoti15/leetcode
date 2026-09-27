class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> map = new HashMap<>();

        for (List<String> kl : knowledge) {
            map.put(kl.get(0), kl.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (Character.isAlphabetic(s.charAt(i))) {
                result.append(s.charAt(i));
            } else { //(
                i++;
                StringBuilder temp = new StringBuilder();
                while (i < n && s.charAt(i) != ')') {
                    temp.append(s.charAt(i));
                    i++;
                }
                result.append(map.getOrDefault(temp.toString(), "?"));
            }
            i++;
        }

        return result.toString();
    }
}
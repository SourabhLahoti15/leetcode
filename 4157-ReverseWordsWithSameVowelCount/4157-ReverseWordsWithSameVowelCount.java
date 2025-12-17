// Last updated: 12/17/2025, 10:50:43 AM
class Solution {
    public int vowelCount(String s) {
        char[] vowels = {'a', 'e','i', 'o', 'u'};
        int count = 0;
        for (char c : s.toCharArray()) {
            for (char v : vowels) {
                if (c == v) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int firstcount = vowelCount(words[0]);
        for (int i=1; i<words.length; i++) {
            int wordcount = vowelCount(words[i]);
            if (wordcount == firstcount) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }
}
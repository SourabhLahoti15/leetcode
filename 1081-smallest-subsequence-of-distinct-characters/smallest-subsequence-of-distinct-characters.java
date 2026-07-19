class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] last = new int[26];
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            last[ch-'a'] = i;
        }
        Stack<Integer> stk = new Stack<>();
        HashSet<Character> hset = new HashSet<>();
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if (hset.contains(ch)) continue;
            while (!stk.isEmpty()) {
                char prev = s.charAt(stk.peek());
                if (prev > ch && last[prev-'a']>i) {
                    stk.pop();
                    hset.remove(prev);
                } else {
                    break;
                }
            }
            stk.push(i);
            hset.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(s.charAt(stk.pop()));
        }
        sb.reverse();
        return sb.toString();
    }
}
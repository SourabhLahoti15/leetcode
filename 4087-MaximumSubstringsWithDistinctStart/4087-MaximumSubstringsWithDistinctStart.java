// Last updated: 12/17/2025, 10:50:45 AM
import java.util.*;
class Solution {
    public int maxDistinct(String s) {
        HashSet<Character> hs = new HashSet<>();
        for (char c : s.toCharArray()) {
            hs.add(c);
        }
        return hs.size();
    }
}
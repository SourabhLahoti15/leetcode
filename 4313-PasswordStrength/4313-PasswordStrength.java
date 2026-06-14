// Last updated: 6/14/2026, 10:03:37 AM
class Solution {
    public int passwordStrength(String password) {
        HashSet<Character> set = new HashSet<>();
        int strength = 0;
        for (char ch : password.toCharArray()) {
            if (!set.contains(ch)) {
                if (Character.isDigit(ch)) {
                    strength += 3;
                } else if (Character.isLetter(ch)) {
                    if (Character.isUpperCase(ch)) {
                        strength += 2;
                    } else {
                        strength += 1;
                    }
                } else {
                    strength += 5;
                }
            }
            set.add(ch);
        }
        return strength;
    }
}
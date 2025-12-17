// Last updated: 12/17/2025, 10:54:39 AM
import java.util.*;
class Solution {
    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int ans=0;

        for(int i=0; i<s.length()-1; i++){
            int current = romanMap.get(s.charAt(i));
            int next = romanMap.get(s.charAt(i+1));
            if (current>=next){
                ans += current;
            } else {
                ans -= current;
            }
        }
        ans += romanMap.get(s.charAt(s.length() - 1));
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = romanToInt(s);
        System.out.println(n);
    }
}
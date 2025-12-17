// Last updated: 12/17/2025, 10:54:46 AM
class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int straight = x;
        int rev = 0;
        while(x>0){
            int ld = x%10;
            rev = rev*10 + ld;
            x = x/10;
        }
        return (straight==rev);
    }
    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPalindrome(n));
    }
}
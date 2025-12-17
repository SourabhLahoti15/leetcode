// Last updated: 12/17/2025, 10:53:44 AM
class Solution {
    public int eval(int a, String opr, int b) {
        switch (opr) {
            case "+":
            return a+b;
            case "-":
            return a-b;
            case "*":
            return a*b;
            case "/":
            return a/b;
        }
        return -1;
    }
    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String s : tokens) {
            if (isNumber(s)) {
                stk.push(Integer.parseInt(s));
            } else {
                int b = stk.pop();
                int a = stk.pop();
                stk.push(eval(a, s, b));
            }
        }
        return stk.pop();
    }
}
import java.util.Stack;

/**
 * @souce: https://leetcode.com/problems/valid-parentheses/
 * Java Stack Class
 */

public class ValidParences {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[";
        System.out.println(isValid(s));
    }
}

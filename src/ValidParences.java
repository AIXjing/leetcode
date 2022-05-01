import java.util.LinkedList;
import java.util.List;
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

    public static boolean isValidLinkedList(String s) {
        if (s.isEmpty()) return false;
        List<Character> li = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') li.add(')');
            else if (c == '[') li.add(']');
            else if (c == '{') li.add('}');
            // if the first character in string is ']', ')' or '}', the li must be empty.
            else if (li.isEmpty() || li.remove(li.size() - 1) != c) {
                return false;
            }
        }
        return li.isEmpty();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(isValidLinkedList(s));
    }
}

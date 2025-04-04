import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: chz
 * @Date: 2025/3/30 15:58
 * @Description: TODO
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * <p>
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(]"
 * <p>
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: s = "([])"
 * <p>
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 **/
public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty() && map.containsKey(c)) {
                    char expected = map.get(c);
                    if (stack.pop() != expected) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid2(String str) {
        char[] stack = new char[str.length()]; // Using a character array as a stack
        int top = -1; // Pointer to track the top of the stack

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch; // Push to stack
            } else {
                if (top == -1) {
                    return false; // No matching opening bracket
                }
                char last = stack[top]; // Get top element
                if ((ch == ')' && last == '(') ||
                        (ch == '}' && last == '{') ||
                        (ch == ']' && last == '[')) {
                    top--; // Pop from stack
                } else {
                    return false; // Mismatched closing bracket
                }
            }
        }
        return top == -1; // Stack should be empty if valid
    }

    public static void main(String[] args) {
        String s = "{{{[()()]}}}";
        boolean result = new ValidParentheses().isValid(s);
        System.out.println(result);
    }
}

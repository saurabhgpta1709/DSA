package Stack;

import java.util.Stack;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 */

public class BalancedParentheses {

    public static void main(String[] args) {
        String s = "[()()]{}";
        System.out.println((isBalanced(s) ? "true" : "false"));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {

                // No opening bracket
                if (st.isEmpty()) return false;
                char top = st.peek();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }

                // Pop matching opening bracket
                st.pop();
            }
        }

        // Balanced if stack is empty
        return st.isEmpty();
    }
}

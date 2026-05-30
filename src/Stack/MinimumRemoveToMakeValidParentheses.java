package Stack;

import java.util.*;

/*
Example 1
Input:
"lee(t(c)o)de)"
Output:
"lee(t(c)o)de"
Example 2
Input:
"a)b(c)d"
Output:
"ab(c)d"
 */
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        String str= "lee(t(c)o)de)";
        String result = minRemoveToMakeValid(str);
        System.out.print(result);

    }

    public static String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();

        Set<Integer> remove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening bracket
            if (ch == '(') {
                stack.push(i);
            }

            // Closing bracket
            else if (ch == ')') {

                // Matching opening exists
                if (!stack.isEmpty()) {
                    stack.pop();
                }

                // Extra closing bracket
                else {
                    remove.add(i);
                }
            }
        }

        // Unmatched opening brackets
        while (!stack.isEmpty()) {
            remove.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (!remove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}

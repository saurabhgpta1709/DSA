package Stack;

import java.util.Stack;

public class removeAdjacentDuplicatePairs {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty() &&
                    stack.peek() == ch) {

                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}

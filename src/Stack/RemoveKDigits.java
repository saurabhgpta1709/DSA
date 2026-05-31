package Stack;

import java.util.Stack;

/*
Remove exactly K digits from a number so that the resulting number is as small as possible.

Problem Statement
Given:
num = "1432219"
k = 3
Remove 3 digits.
Return smallest possible number.
 */
public class RemoveKDigits  {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for(char digit : num.toCharArray()) {

            while(k > 0 &&
                    !stack.isEmpty() &&
                    stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for(char c : stack) {
            sb.append(c);
        }

        while(sb.length() > 0 &&
                sb.charAt(0) == '0') {

            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}

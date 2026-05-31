package Stack;

import java.util.Stack;

/*
Given an encoded string, decode it.
Example
Input:
3[a2[c]]
Output:
accaccacc
Explanation:
a2[c]
= acc
3[acc]
= accaccacc
 */
public class DecodeStringPattern {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()) {

            if(Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            }

            else if(ch == '[') {

                countStack.push(k);
                stringStack.push(current);

                current = new StringBuilder();
                k = 0;
            }

            else if(ch == ']') {

                int count = countStack.pop();
                StringBuilder prev = stringStack.pop();

                while(count-- > 0) {
                    prev.append(current);
                }

                current = prev;
            }

            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}

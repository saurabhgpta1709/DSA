package BracketProblems;

import java.util.Stack;

public class LongestBalancedParentheses {

    public static void main(String[] args) {
        String str="()()()()()()()(((((((";
        System.out.println("Longest length is :"+getLongestBalancedParenthesesLength(str)); ;
    }

    private static int getLongestBalancedParenthesesLength(String str) {
        Stack<Character> stack = new Stack<>();
        int maxLength=0;
        int finalLength=0;

        for (char c : str.toCharArray()){
            if(c=='('){
                stack.add('(');
                maxLength++;
            } else if (c==')') {
                char curr = stack.peek();
                if(curr =='('){
                    stack.pop();
                    maxLength ++;
                    finalLength=maxLength;
                }else{
                    return finalLength;
                }
            }
        }
        return  finalLength;
    }
}

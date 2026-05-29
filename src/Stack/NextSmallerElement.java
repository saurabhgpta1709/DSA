package Stack;

import java.util.Stack;

/*
Find first smaller element on right.

Example
Input:
[4,8,5,2,25]
Output:
[2,5,2,-1,-1]
 */
public class NextSmallerElement {
    public static void main(String[] args) {
        int [] arr = {4,8,5,2,25};
        int [] result  = nextSmaller(arr);
        for (int i: result){
            System.out.print(i+",");
        }
    }
    public static int[] nextSmaller(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!stack.isEmpty() &&
                    stack.peek() >= arr[i]) {

                stack.pop();
            }

            ans[i] = stack.isEmpty()
                    ? -1
                    : stack.peek();

            stack.push(arr[i]);
        }

        return ans;
    }

}

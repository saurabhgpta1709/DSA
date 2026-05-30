package Stack;

import java.util.Stack;

/*
Find first greater element on right side for every element.

Example
Input:
[2,1,2,4,3]
Output:
[4,2,4,-1,-1]
 */
public class NextGreaterElement {

    public static void main(String[] args) {
       int [] arr = {2,1,2,4,3};
        int [] result  = nextGreater(arr);
        for (int i: result){
            System.out.print(i+",");
        }
    }

    public static int[] nextGreater(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!stack.isEmpty() &&
                    stack.peek() <= arr[i]) {

                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return ans;
    }
}

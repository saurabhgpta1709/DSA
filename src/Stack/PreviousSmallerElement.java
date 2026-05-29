package Stack;

import java.util.Stack;

/*
Find nearest smaller element on left.

Example
Input:
[1,6,4,10,2,5]
Output:
[-1,1,1,4,1,2]
 */
public class PreviousSmallerElement {
    public static void main(String[] args) {
        int [] arr = {1,6,4,10,2,5};
        int [] result  = previousSmaller(arr);
        for (int i: result){
            System.out.print(i+",");
        }
    }

    public static int[] previousSmaller(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {

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

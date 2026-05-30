package Stack;

/*
Find nearest greater element on left side.

Example
Input:
[10,4,2,20,40,12]
Output:
[-1,10,4,-1,-1,40]
 */

import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12};
        int[] result = previousGreater(arr);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public static int[] previousGreater(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    stack.peek() <= arr[i]) {

                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return ans;
    }
}

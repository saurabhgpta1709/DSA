package Stack;

import java.util.Stack;

public class NextGreaterElementInCircularArray {
    public static void main(String[] args) {
        int [] arr = {2,1,2,4,3};
        int [] result  = nextGreaterElements(arr);
        for (int i: result){
            System.out.print(i+",");
        }
    }

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Preload stack with n-2 to 0
        for (int i = n - 2; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    stack.peek() <= nums[i]) {
                stack.pop();
            }

            stack.push(nums[i]);
        }

        // Normal NGE from n-1 to 0
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    stack.peek() <= nums[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty()
                    ? -1
                    : stack.peek();

            stack.push(nums[i]);
        }

        return ans;
    }
}

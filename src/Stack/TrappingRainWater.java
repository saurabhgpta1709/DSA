package Stack;

import java.util.Stack;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int [] arr = {1,6,4,10,2,5};
        int  result  = trap(arr);
            System.out.print(result);

    }

    public static int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();

        int water = 0;

        for(int i = 0; i < height.length; i++) {

            while(!stack.isEmpty() &&
                    height[i] > height[stack.peek()]) {

                int top = stack.pop();

                if(stack.isEmpty()) {
                    break;
                }

                int distance =
                        i - stack.peek() - 1;

                int boundedHeight =
                        Math.min(height[i],
                                height[stack.peek()])
                                - height[top];

                water += distance * boundedHeight;
            }

            stack.push(i);
        }

        return water;
    }
}

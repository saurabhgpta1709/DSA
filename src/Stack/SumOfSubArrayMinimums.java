package Stack;

import java.util.Stack;

/*
Find minimum of every possible subarray and add them.

Problem Statement
Given:
[3,1,2,4]
Calculate:
minimum([3])
minimum([3,1])
minimum([3,1,2])
minimum([3,1,2,4])
Add all minimums.
Example
Subarrays:
[3] = 3
[3,1] = 1
[3,1,2] = 1
[3,1,2,4] = 1
[1] = 1
[1,2] = 1
[1,2,4] = 1
[2] = 2
[2,4] = 2
[4] = 4
Answer:
17
 */
public class SumOfSubArrayMinimums {
    public static void main(String[] args) {
        int  [] arr={3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++) {

            while(!stack.isEmpty() &&
                    arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty()
                    ? i+1
                    : i-stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--) {

            while(!stack.isEmpty() &&
                    arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty()
                    ? n-i
                    : stack.peek()-i;

            stack.push(i);
        }

        long ans=0;

        for(int i=0;i<n;i++) {
            ans += (long)arr[i] * left[i] * right[i];
        }

        return (int)ans;
    }
}

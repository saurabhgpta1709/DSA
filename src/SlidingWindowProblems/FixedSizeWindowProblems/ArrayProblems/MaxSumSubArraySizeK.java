package SlidingWindowProblems.FixedSizeWindowProblems.ArrayProblems;

public class MaxSumSubArraySizeK {
    public static void main(String[] args) {
        int arr[] = {100, 200, 300, 400};
        int k = 3;
        int maxSum = maxSubArraySum(arr, k);
        System.out.println(maxSum);
    }

    public static int maxSubArraySum(int[] arr, int k) {
        // Code here
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += arr[i];
        maxSum = windowSum;

        for (int j = k; j < arr.length; j++) {
            windowSum += arr[j] - arr[j - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}

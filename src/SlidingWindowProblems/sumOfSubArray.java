package SlidingWindowProblems;

import java.util.ArrayList;

/*********** Problem Statement************
 * Find continuous subarray whose sum equals a specified value target
 *
 * Example:
 * Input: arr[] = [1, 2, 3, 7, 5], target = 12
 * Output: [2, 4]
 * Explanation: The sum of elements from 2nd to 4th position is 12.
 *
 ******************************************/
public class sumOfSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;
        ArrayList<Integer> list = subArraySum(arr, target);
        System.out.println(list);
    }

    /*Time Complexity = n2*/
//    private static ArrayList<Integer> subArraySum(int[] arr, int target) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < arr.length; i++) {
//            int sum = arr[i];
//            for (int j = i + 1; j < arr.length; j++) {
//                sum += arr[j];
//                if (sum == target) {
//                    list.add(i + 1);
//                    list.add(j + 1);
//                    return list;
//                }
//            }
//        }
//        return list;
//    }

    private static ArrayList<Integer> subArraySum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int commulativeSum = 0;
        for (int end = 0; end < arr.length; end++) {
            commulativeSum += arr[end];
            while (start < end && commulativeSum > target ) {
                commulativeSum -= arr[start];
                start++;
            }
            if (commulativeSum == target) {
                list.add(start+1);
                list.add(end+1);
                return list;
            }
        }
        list.add(-1);
        return list;
    }
}

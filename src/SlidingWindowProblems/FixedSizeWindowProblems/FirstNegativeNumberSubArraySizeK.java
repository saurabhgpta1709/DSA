package SlidingWindowProblems.FixedSizeWindowProblems;

import java.util.ArrayList;
import java.util.List;

/************ Problem Statement************
* Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
* Output: [-1, -1, -7, -15, -15, 0]
* Explanation: First negative integer for each window of size 3
 [ 12, -1, -7] = -1
 [-1,-7, 8] = -1
 [-7, 8, -15] = -7
 [8, -15, 30] = -15
 [-15, 30, 16] = -15
 [30, 16, 28] = 0
 ******************************************/


public class FirstNegativeNumberSubArraySizeK {
    public static void main(String[] args) {
        int [] arr ={12, -1, -7, 8, -15, 30, 16, 28};
        int k=3;
        List<Integer> list = findFirstNegativeNumberSubArraySizeK(arr,k);
        System.out.println(list);
    }

    private static List<Integer>  findFirstNegativeNumberSubArraySizeK(int[] arr, int k) {
        List<Integer> list= new ArrayList<>();
        int fstNegIdx = 0;
        int n = arr.length;


        for (int i = k - 1; i < n; i++) {
            // Skip out of window and positive elements
            while (fstNegIdx < i && (fstNegIdx <= i - k || arr[fstNegIdx] >= 0)) {
                fstNegIdx++;
            }

            // Check if a negative element is found,
            // otherwise use 0
            if (fstNegIdx < n && arr[fstNegIdx] < 0) {
                list.add(arr[fstNegIdx]);
            } else {
                list.add(0);
            }
        }
        return list;
    }
}

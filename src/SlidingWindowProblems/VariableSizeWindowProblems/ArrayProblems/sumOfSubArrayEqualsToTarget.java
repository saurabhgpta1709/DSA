package SlidingWindowProblems.VariableSizeWindowProblems.ArrayProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*********** Problem Statement************
 * Find continuous subarray whose sum equals a specified value target
 *
 * Example:
 * Input: arr[] = [1, 2, 3, 7, 5], target = 12
 * Output: [2, 4]
 * Explanation: The sum of elements from 2nd to 4th position is 12.
 *
 ******************************************/
public class sumOfSubArrayEqualsToTarget {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 7, 5};
        int target = 12;
        List<Integer> list = subArraySum(arr, target);
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

//    private static ArrayList<Integer> subArraySum(int[] arr, int target) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int start = 0;
//        int commulativeSum = 0;
//        for (int end = 0; end < arr.length; end++) {
//            commulativeSum += arr[end];
//            while (start < end && commulativeSum > target ) {
//                commulativeSum -= arr[start];
//                start++;
//            }
//            if (commulativeSum == target) {
//                list.add(start+1);
//                list.add(end+1);
//                return list;
//            }
//        }
//        list.add(-1);
//        return list;
//    }

    public static List<Integer> subArraySum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            if (map.containsKey(prefixSum - target)) {
                list.add(map.get(prefixSum - target) + 1);
                 list.add(i+1);
            return list;
            }

            map.put(prefixSum, i);
        }

        list.add(-1);
        return list;
    }

//    int k =2;
//
//    List<Integer> list = new ArrayList<>();
//
//    int start = 0; int end = k-1;
//
//        while(start < arr.length -1){
//
//        List<Integer> tempList = new ArrayList<>();
//
//        tempList.add(arr[start]);
//
//        tempList.add(arr[end]);
//
//        list.add(Collections.max(tempList));
//
//        start++;
//
//        end++;
//
//    }
//
//        for(int i : list){
//
//        System.out.println(i + " ");
//
//    }

}

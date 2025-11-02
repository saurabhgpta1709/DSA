package SlidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

/*********** Problem Statement************
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 ******************************************/

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 13;
        int[] output = twoSum(arr, target);
        if (output.length == 2) {
            System.out.println("Output: {" + output[0] + ", " + output[1] + "}");
        } else {
            System.out.println("No pair found for target " + target);
        }
    }

    /*Time Complexity = n2 */
//    public static int[] twoSum(int[] arr, int target) {
//        int [] output = new int[2];
//        for(int k=0;k<arr.length;k++){
//            for( int i=k+1;i<arr.length;i++){
//                if((arr[k]+arr[i])==target){
//                    output[0] = k;
//                    output[1] = i;
//                    return output;
//                }
//            }
//        }
//        return output;
//    }

    /*Time Complexity = n */
//    public static int[] twoSum(int arr[], int target) {
//        int [] output = new int[2];
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int k = 0; k < arr.length; k++) {
//            int cur = arr[k];
//            int x = target - arr[k];
//            if (map.containsKey(x)) {
//                output[0]= map.get(x);
//                output[1]= k;
//                return output;
//            }
//            map.put(arr[k],k);
//        }
//        return output;
//    }

    // Optimized Solution + Clean Code
    /*Time Complexity = n */
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);//map.putIfAbsent(arr[i], i); Can also use this Only put value if it doesn't already exist to avoid overwriting
        }

        // Return empty array or throw exception if no pair found
        return new int[0];
    }
}

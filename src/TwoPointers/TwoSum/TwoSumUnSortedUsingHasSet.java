package TwoPointers.TwoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

public class TwoSumUnSortedUsingHasSet {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 22;
       twoSum(arr, target);

    }

    // Optimized Solution + Clean Code
    /*Time Complexity = n */
    public static void twoSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num:arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println(complement+","+num);
            }else{
                set.add(num);
            }

        }

    }
}

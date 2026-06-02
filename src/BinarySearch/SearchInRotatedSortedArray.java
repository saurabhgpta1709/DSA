package BinarySearch;
/*
You are given a sorted array that has been rotated at some pivot.
Find the index of the target element.
Example
nums = [4,5,6,7,0,1,2]
target = 0
Output = 4
 */


/************Logic**************
 * In a rotated array, at least one half is always sorted.
 * Example:
 * [4,5,6,7,0,1,2]
 * mid = 7
 * Left Half  = [4,5,6,7]  Sorted
 * Right Half = [0,1,2]
 * Algorithm
 * Find mid.
 * Check which half is sorted.
 * Determine if target lies in that half.
 * Discard the other half.
 *
 * Time  : O(log n)
 * Space : O(1)
 *******************************/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        int target =7;
        int result = search(arr,target);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            // Left half sorted
            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] &&
                        target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half sorted
            else {

                if (target > nums[mid] &&
                        target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

package BinarySearch;
/*
Find the minimum element.
Example
[4,5,6,7,0,1,2]
Output = 0
 */

/****************Logic**************
 * 4,5,6,7,0,1,2]
 * mid = 7
 * 7 > 2
 * Minimum on right side
 ************************************/
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        int minNum = findMin(arr);
        System.out.println(minNum);
    }

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}

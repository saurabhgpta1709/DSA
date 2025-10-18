package SlidingWindowProblems;

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
        int[] arr ={2,7,11,15};
        int target =9;
        int[] output =twoSum(arr,target);
        System.out.println("output: {"+output[0]+','+output[1]+'}');
    }

    /*Time Complexity = n2 */
    public static int[] twoSum(int[] arr, int target) {
        int [] output = new int[2];
        for(int k=0;k<arr.length-1;k++){
            for( int i=k+1;i<arr.length;i++){
                if((arr[k]+arr[i])==target){
                    output[0] = k;
                    output[1] = i;
                    return output;
                }
            }
        }
        return output;
    }
}
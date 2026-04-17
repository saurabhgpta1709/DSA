package ArrayProblems;

public class RotateArray {
    public static void main(String[] args) {


        int [] arr ={1,2,3,4,5,6};
        rotate(arr,2);
    }

    // time complexity O(n) but it takes extra space
    public static void rotate(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;
        int[] result = new int[nums.length];
        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }
        int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, nums.length );
    }
}

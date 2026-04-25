package TwoPointers.RemoveDuplicates;

public class removeDuplicatesSortedArrayFastAndSlowPointer {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer

        for (int j = 1; j < nums.length; j++) { // fast pointer

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // overwrite duplicate
            }
        }

        return i + 1; // number of unique elements
    }

}

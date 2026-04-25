package TwoPointers.RemoveDuplicates;

public class removeDuplicatesSortedArrayTwoPointer {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0; // left pointer
        int right = 1; // right pointer
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right]; // overwrite duplicate
            }
            right++;
        }
        return left + 1; // number of unique elements
    }

}

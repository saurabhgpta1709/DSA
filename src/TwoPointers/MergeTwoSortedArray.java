package TwoPointers;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[m+n];
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        int k = 0; // Pointer for merged array

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        // If there are remaining elements in nums2, copy them
        while (j < n) {
            result[k++] = nums2[j++];
        }

        while (i < n) {
            result[k++] = nums1[i++];
        }

        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}

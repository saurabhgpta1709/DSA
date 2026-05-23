package TwoPointers.RemoveDuplicates;

import java.util.*;


public class removeDuplicatesUnSortedArrayLinkedHashSet {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int[] result = removeDuplicates(arr);

        System.out.println(Arrays.toString(result));
    }

    public static int[] removeDuplicates(int[] arr) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        int index = 0;

        for (int num : set) {
            result[index++] = num;
        }

        return result;
    }

}

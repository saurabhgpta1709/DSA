package ArrayProblems;

/******************************************
* When to use?
* Unsorted array
* Small data
* Time Complexity : O(n)
********************************************/
public class LinearSearch {
    public static void main(String[] args) {
        int [] arr= {1,5,4,3,6,9,292,284,54};
        int target =4;
        System.out.println(linearSearchLogic(arr,target));
    }
    public static boolean linearSearchLogic(int[] a, int target){
        for (int j : a) {
            if (j == target) return true;
        }
        return false;
    }
}


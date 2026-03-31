package ArrayProblems;
/************************************
* If array is sorted → Think Binary Search first
* Works only on sorted array
* Time Complexity: O(log n)
 ************************************/
public class BinarySearch {
    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5,6,7,8,9};
        int target =4;
        System.out.println(binarySearch(arr,target));
    }

    static int binarySearch(int[] a, int target){
        int l=0, r=a.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(a[mid]==target) return mid;
            else if(a[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}

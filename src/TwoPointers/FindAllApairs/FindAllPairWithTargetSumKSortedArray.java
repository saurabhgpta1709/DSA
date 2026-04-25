package TwoPointers.FindAllApairs;

public class FindAllPairWithTargetSumKSortedArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        findAllPairWithTargetSumK(arr,target);
    }

    public static void findAllPairWithTargetSumK(int [] arr,int target){
        int left=0;
        int right = arr.length-1;
        while(left<right){
            if(target == (arr[left]+arr[right])){
                System.out.println("Pair found: {" + arr[left] + ", " + arr[right] + "}");
                left++;
                right--;
            }else if (target>(arr[left]+arr[right])){
                left++;
            }else{
                right--;
            }
        }
    }
}

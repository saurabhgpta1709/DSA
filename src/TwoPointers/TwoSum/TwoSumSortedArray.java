package TwoPointers.TwoSum;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        int [] arr = {2,7,11,15};
        int target =9;
        int [] result= twoSum(arr,target);
        for (int indices : result) {
            System.out.print(indices);
        }
    }

    static public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right = numbers.length-1;
        while(left<right){
            if(target == (numbers[left]+numbers[right])){
                return new int [] {left+1,right+1};
            }else if (target>(numbers[left]+numbers[right])){
                left++;
            }else{
                right--;
            }
        }
        return new int [] {-1,-1};
    }
}

package TwoPointers.FindAllApairs;

import java.util.HashMap;

public class FIndAllPairsHashMap {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
        int target = 10;
        findAllPairWithTargetSumK(arr,target);
    }

    public static void findAllPairWithTargetSumK(int [] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            int num = arr[i];
            int complement = target - num;
            if (map.containsKey(complement)) {
                System.out.println("Pair found: {" + complement + ", " + num + "}");
            }
            map.put(num,i);
        }
    }
}

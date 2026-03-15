package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {

        String input = "swiss";

        System.out.println(firstNonRepeating(input));
    }

    private static char firstNonRepeating(String input) {
        Map<Character,Integer> map = new HashMap<>();
        for(char current : input.toCharArray())
            map.put(current,map.getOrDefault(current,0)+1);
//        for (int i = 0; i < input.length(); i++) {
//            char current = input.charAt(i);
//            if(map.containsKey(current)) {
//                map.put(current,map.get(current)+1);
//            }else{
//                map.put(current,1);
//            }
//        }
        for(char current : input.toCharArray()){
            if(map.get(current)==1) return current;
        }

        return '-';
    }



//    public static char firstNonRepeating(String s){
//
//        int[] freq = new int[256];
//
//        for(char c : s.toCharArray())
//            freq[c]++;
//
//        for(char c : s.toCharArray())
//            if(freq[c] == 1)
//                return c;
//
//        return '-';
//    }

}

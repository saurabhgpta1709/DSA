package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfChar {
    public static void main(String[] args) {
        String s = "aaabbcdddddddeff";
        countOccurrence(s);
    }

    private static void countOccurrence(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char [] arr= s.toCharArray();
        for(char c: arr) map.put(c,map.getOrDefault(c,0)+1);

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+"-->"+entry.getValue());
        }
//        map.forEach((key,value)-> System.out.println(key+","+value));
    }
}

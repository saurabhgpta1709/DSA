package SlidingWindowProblems.VariableSizeWindowProblems.StringProblems;

import java.util.HashMap;
import java.util.Map;

/*********** Problem Statement************
* Input: s = "timetopractice", p = "toc"
* utput: "toprac"
* Explanation: "toprac" is the smallest substring in which "toc" can be found.
 ******************************************/

public class minWindowContainingAllChar {
    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";

        String res = minWindow(s, p);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);

        int left=0,count=t.length(),start=0,minLen=Integer.MAX_VALUE;

        for(int right=0;right<s.length();right++){

            char c=s.charAt(right);

            if(map.containsKey(c)){
                if(map.get(c)>0) count--;
                map.put(c,map.get(c)-1);
            }

            while(count==0){

                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }

                char leftChar=s.charAt(left);

                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(leftChar)>0) count++;
                }

                left++;
            }
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}

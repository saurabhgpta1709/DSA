package SlidingWindowProblems.VariableSizeWindowProblems.StringProblems;

import java.util.ArrayList;
import java.util.List;

/*********** Problem Statement************
 *
 *
 *
 *****************************************/


public class AllAnagramsInString {
    public static void main(String[] args) {
        String s="forxxorfxdofr";
        String p ="for";
        System.out.println(findAnagrams(s,p));
    }
    public static List<String> findAnagrams(String s, String p) {

        List<String> result = new ArrayList<>();
        int[] count = new int[26];

        for (char c : p.toCharArray())
            count[c - 'a']++;

        int left = 0, right = 0, needed = p.length();

        while (right < s.length()) {

            if (count[s.charAt(right) - 'a']-- > 0)
                needed--;

            right++;

            if (needed == 0)
                result.add(s.substring(left,left+p.length()));

            if (right - left == p.length()) {

                if (count[s.charAt(left) - 'a']++ >= 0)
                    needed++;

                left++;
            }
        }

        return result;
    }
}

package SlidingWindowProblems.VariableSizeWindowProblems.StringProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {

        String s = "abcabcdebb";

        System.out.println(LongestSubstring(s));
    }

    public static String LongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        int startIndex=0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }

            map.put(current, right);
            if (right - left + 1 > maxLength ) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }
}

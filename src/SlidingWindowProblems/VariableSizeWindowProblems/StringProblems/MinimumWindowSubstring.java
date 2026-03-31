package SlidingWindowProblems.VariableSizeWindowProblems.StringProblems;

/***************************************************
* Given two strings s and t, find the smallest substring in s that contains all characters of t.
* s = "ADOBECODEBANC"
* t = "ABC"
* Output = "BANC"
*****************************************************/

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Store frequency of t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Expand window
        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);

                if (map.get(current) >= 0) {
                    count++;
                }
            }

            // Step 3: Shrink window
            while (count == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}

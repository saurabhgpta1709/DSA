package SlidingWindowProblems.VariableSizeWindowProblems.StringProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKUniqueChar {
    public static void main(String[] args) {

        String s = "eceba";
        int k = 2;

        System.out.println(longestSubstringKUnique(s, k));
    }

    public static int longestSubstringKUnique(String s, int k) {

        if (s == null || s.isEmpty() || k == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);
            map.put(current, map.getOrDefault(current, 0) + 1);

            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

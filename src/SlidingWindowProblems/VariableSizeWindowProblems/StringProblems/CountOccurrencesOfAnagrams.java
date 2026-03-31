package SlidingWindowProblems.VariableSizeWindowProblems.StringProblems;

/*
* txt = "forxxorfxdofr"
* pat = "for"
* Output = 3
* Anagrams: "for", "orf", "ofr"
*/

import  java.util.*;

public class CountOccurrencesOfAnagrams {

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";

        System.out.println(countAnagrams(txt, pat)); // Output: 3
    }

    public static int countAnagrams(String txt, String pat) {

        if (pat.length() > txt.length()) return 0;

        int[] patCount = new int[26];
        int[] windowCount = new int[26];

        // Step 1: count pattern frequency
        for (char c : pat.toCharArray()) {
            patCount[c - 'a']++;
        }

        int count = 0;
        int k = pat.length();
        int left = 0;

        // Step 2: sliding window
        for (int right = 0; right < txt.length(); right++) {

            windowCount[txt.charAt(right) - 'a']++;

            // maintain window size
            if (right - left + 1 > k) {
                windowCount[txt.charAt(left) - 'a']--;
                left++;
            }

            // Step 3: compare
            if (Arrays.equals(patCount, windowCount)) {
                count++;
            }
        }

        return count;
    }
}

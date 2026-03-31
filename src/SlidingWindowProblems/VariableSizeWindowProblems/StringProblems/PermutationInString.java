package SlidingWindowProblems.VariableSizeWindowProblems.StringProblems;

/*
* Given two strings s1 and s2, check if any permutation of s1 exists as a substring in s2.
* s1 = "ab"
* s2 = "eidbaooo"
* Output = true   // "ba" exists in s2
*/

import java.util.*;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Step 1: count s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int left = 0;

        // Step 2: sliding window
        for (int right = 0; right < s2.length(); right++) {

            char r = s2.charAt(right);
            windowCount[r - 'a']++;

            // keep window size equal to s1 length
            if (right - left + 1 > s1.length()) {
                char l = s2.charAt(left);
                windowCount[l - 'a']--;
                left++;
            }

            // Step 3: compare arrays
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }
}

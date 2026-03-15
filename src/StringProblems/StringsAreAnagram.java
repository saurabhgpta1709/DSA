package StringProblems;

public class StringsAreAnagram {
    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        System.out.println(isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2) {
        s1= s1.toLowerCase();
        s2= s2.toLowerCase();

        if (s1.length() != s2.length())
            return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray())
            freq[c - 'a']++;

        for (char c : s2.toCharArray())
            freq[c - 'a']--;

        for (int count : freq)
            if (count != 0)
                return false;

        return true;
    }
}

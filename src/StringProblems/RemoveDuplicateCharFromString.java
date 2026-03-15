package StringProblems;

public class RemoveDuplicateCharFromString {
    public static void main(String[] args) {
        String str = "aaabbccccdefgggh";
        System.out.println(removeDuplicateChar(str));
    }

    private static StringBuilder removeDuplicateChar(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] freq = new boolean[26];
        char[] arr = str.toCharArray();

        for (char c : arr) {
            if (!freq[c - 'a']) {
                freq[c - 'a'] = true;
                result.append(c);
            }
        }
        return result;
    }
}

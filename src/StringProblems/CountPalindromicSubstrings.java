package StringProblems;

public class CountPalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

        static int count = 0;

        public static int countSubstrings(String s) {

            for (int i = 0; i < s.length(); i++) {

                expand(s, i, i);

                expand(s, i, i + 1);
            }

            return count;
        }

        private static void expand(String s, int left, int right) {

            while (left >= 0 &&
                    right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                count++;

                left--;
                right++;
            }
        }

}

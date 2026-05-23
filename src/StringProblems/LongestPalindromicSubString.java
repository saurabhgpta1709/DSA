package StringProblems;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }

    private static String longestPalindrome(String str) {
        int start=0;
        int end=0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = expand(str,i,i);
            int len2 = expand(str,i,i+1);
            int maxLen = Math.max(len1,len2);

            if(maxLen> end-start){
                start=i-(maxLen-1)/2;
                end =i+maxLen/2;
            }
        }
        return str.substring(start,end+1);
    }

    private static int expand(String str, int left, int right) {
        while (right<str.length() && left>=0 && str.charAt(left)==str.charAt(right)){
            left --;
            right ++;
        }
        return right - left - 1;
    }
}

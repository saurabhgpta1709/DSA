package StringProblems;

public class ReverseCharactersOfSentence {
    public static void main(String[] args) {
        String str= "I Love Java";
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s) {

        char[] arr = s.toCharArray();
        StringBuilder result= new StringBuilder();

        for (int i = arr.length-1; i >=0; i--) {
            result.append(arr[i]);
        }

        return result.toString();
    }
}

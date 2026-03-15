package StringProblems;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String str= "I Love Java";
        System.out.println(reverseWords(str));
    }

    private static StringBuilder reverseWords(String str) {
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length-1; i >=0 ; i--) {
            result.append(words[i]);
            if(i != 0)
                result.append(" ");
        }
        return result;
    }
}

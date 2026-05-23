
import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String str=frequencySort("tree");
        System.out.println(str);
    }

        public static String frequencySort(String s) {

            Map<Character, Integer> map = new HashMap<>();

            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Bucket array
            List<Character>[] bucket = new List[s.length() + 1];

            for (char ch : map.keySet()) {

                int freq = map.get(ch);

                if (bucket[freq] == null) {
                    bucket[freq] = new ArrayList<>();
                }

                bucket[freq].add(ch);
            }

            StringBuilder sb = new StringBuilder();

            // Traverse from high freq to low
            for (int i = bucket.length - 1; i >= 0; i--) {

                if (bucket[i] != null) {

                    for (char ch : bucket[i]) {

                        for (int j = 0; j < i; j++) {
                            sb.append(ch);
                        }
                    }
                }
            }

            return sb.toString();
        }

}

package StringProblems;

import java.util.*;

public class SortStringAccToCharacterFreq {
    public static void main(String[] args) {
        String input = "trreee";
        System.out.println(sortByFrequency(input)); // Output: eetr
    }

    //bucket Sort
    public static String sortByFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];

        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        StringBuilder result = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }

    /*
    public static String sortByFrequency(String s) {

        // Step 1: Count frequency
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a)
        );

        maxHeap.addAll(map.keySet());

        // Step 3: Build result
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int freq = map.get(ch);

            while (freq-- > 0) {
                result.append(ch);
            }
        }

        return result.toString();
    }
     */

    /*
    public static String sortByFrequency(String s) {

        Map<Character, Long> freqMap =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return freqMap.entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue().intValue()))
                .collect(Collectors.joining());
    }
    */

    /*
    Using Sorting (List + Custom Comparator)
   * Count frequency
   * Put characters into a list
   * Sort based on frequency (descending)
   * Complexity:O(n log n)

    public static String sortByFrequency(String s) {

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Convert to list
        List<Character> list = new ArrayList<>(map.keySet());

        // Step 3: Sort list based on frequency
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Step 4: Build result
        StringBuilder result = new StringBuilder();

        for (char c : list) {
            int freq = map.get(c);
            while (freq-- > 0) {
                result.append(c);
            }
        }

        return result.toString();
    }
    */

    /*
    * Using TreeMap (Frequency as Key)
    * Store frequency → list of characters
    * Use reverse order TreeMap
    * O(n log n)

    public static String sortByFrequency(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // TreeMap in descending order
        TreeMap<Integer, List<Character>> treeMap =
                new TreeMap<>(Collections.reverseOrder());

        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);

            treeMap.putIfAbsent(freq, new ArrayList<>());
            treeMap.get(freq).add(c);
        }

        StringBuilder result = new StringBuilder();

        for (int freq : treeMap.keySet()) {
            for (char c : treeMap.get(freq)) {
                for (int i = 0; i < freq; i++) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
    */
}

package StringProblems;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequency
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (map.get(a).equals(map.get(b))) {
                        return b.compareTo(a); // reverse lexicographical
                    }
                    return map.get(a) - map.get(b); // min heap
                }
        );

        // Step 3: Maintain size k
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build result (reverse order)
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
//        String[] words = {"i","love","leetcode","i","love","coding"};
//        Find most failing endpoint
        String[] words ={"200 /login", "500 /payment", "500 /payment", "404 /home"};


        System.out.println(topKFrequent(words, 1));
    }
}

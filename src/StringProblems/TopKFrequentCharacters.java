package StringProblems;

import java.util.*;

public class TopKFrequentCharacters {
    public static void main(String[] args) {

        List<Character> list =topKFreq("trreeemmmmaaaaapppppp",3);
        System.out.println(list);
    }

    public static List<Character> topKFreq(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> minHeap =
                new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (char c : map.keySet()) {
            minHeap.add(c);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }
}

package SlidingWindowProblems.FixedSizeWindowProblems.ArrayProblems;
import java.util.*;

public class MaximumOfSubArraySizeK {
    public static void main(String[] args) {
        int arr[] = {100, 200, 300, 400};
        int k = 2;
        int [] maxOfSubArray = maxSlidingWindow(arr, k);
        for(int j: maxOfSubArray)
        System.out.println(j);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peek() <= i - k) dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.add(i);

            if (i >= k - 1)
                res[idx++] = nums[dq.peek()];
        }
        return res;
    }
}
